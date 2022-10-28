# Package io
Il package che contiene i metodi per fare I/O si chiama `io`. Esiste anche new `io`.
Contiene 4 classi base astratte:
- `InpuStream`: lettura bytes
- `OutputStream`: scrittura bytes
- `Reader`: lettura caratteri
- `Writer`: scrittura caratteri

Servono per fare I/O in lettura e scrittura, a caratteri e a blocchi. La scrittura e lettura di caratteri può avvenire con i metodi `InputStream` e `OutpuStream`; lo svantaggio è che potrebbero non essere ottimizzati per gestire caratteri rappresentati come UTF-16.

Queste quattro classi forniscono metodi *generici* per leggere e scrivere *flussi* non strutturati di dati. Non esiste lettura fino a fine riga o simili.

Le **classi concrete** che implementano queste classi astratte si dividono in:
- Classi **sorgente/pozzo**: sono legate ad un file o un dispositivo. Non aggiungono funzionalità alle classi astratte, ma le implementano.
	- sorgente: lettura da file o buffer
	- pozzo: scrittura su file o buffer
- Classi **filtro**: non si preoccupano di src o dst, ma elaborano il flusso. Servono ad esempio per convertire stringhe in intero. Senza queste classi "ausiliarie" si potrebbero leggere o scrivere solo byte e non tipi primitivi o oggetti.

## Incapsulamento
> *Incapsulamento*: composizione di un oggetto all'interno di un altro oggetto.

1. creo una classe **sorgente**
2. creo una classe per il **filtraggio**, passando al costruttore l'oggetto sorgente
3. si possono concatenare filtri. Il filtro di livello 2 subirà il filtraggio del livello 1 e ne applicherà un altro

Es: lettura intero -> chunk di 4 byte dallo stream sorgente

```java
import java.io.*;

...
FileInputStream f = new InputStream("fle.dat");
DataInputStream is = new DataInputStream(f);
...
```

Vedi gerarchia di InputStream e OutpuStream:
- InputStream
	- ByteArrayInputStream
	- FileInputStream
	- ObjectInputStream
- OutputStream
	- ByteOutputStream
	- FileOutputStream
	- ObjectOutputStream

## Metodi di InputStream
- `read()` legge uno o più byte
- `available()` quanti byte sono disponibili in input
- `skip()` salta N byte in input. Come `lseek()` in C
- `mark()` salva la posizione corrente sullo stream
- `reset()` torna alla posizione dell'ultimo mark "piantato"
- `markSupported()` ritorna se il mark è supportato dallo stream

## Metodi di OutputStream
- `write()` scrittura di uno opiù byte
- `flush()` commit del buffer sul disco (o comunque sullo stream)
- `close()` chiude lo stream

In Java l'apertura dello stream non può essere invocata esplicitamente. Avviene quando l'oggetto è istanziato.
Attenzione: aperture degli stream sempre in blocchi try-catch -> se l'istanziazione fallisce lo stream non è stato aperto.

## Lettura di un byte
`read()` legge un byte e ritorna un intero a 4 byte. Restituisce questo intero:
- se compreso tra 0 e 255 la lettura è andata a buon fine -> il byte letto è quello meno significativo
- se -1 lo stream è finito

Solitamente si fa:
```bash
int i; byte b;
i = in.read();
if (i != -1) {
	b = (byte) i;
}
```


## Sottoclassi di InputStream
Classi che concretizzano `InputStream`.
### ByteArrayInputStream
Implementa i metodi di `InputStream` nel caso di un buffer di byte. L'array di byte viene passato alla costruzione dell'oggetto.
### FileInputStream
Associa uno stream ad un file. Da mettere in blocco try-catch.
Esempi:
```java
FileInputStream f = new FileInputStream("prova.dat");

// Oppure

File f = new File("prova.dat");
fs = new FileInputStream(f);
```

Di default i filtri che derivano da InputStream è trasparente
## Sottoclassi di FilterInputStream
Filtri notevoli da usare con un InputStream.
### BufferedInputStream
Modifica il metodo `read()` in modo da avere un input **bufferizzato** tramite buffer, aggiunto da filtro. Ogni lettura ritorna il contenuto del buffer. Secondo il principio di località, dovrebbe ridurre la latenza in lettura.
### DataInputStream
Filtro per conversione tra byte stream e **tipi primitivi**:
- `readInteger()`
- `readFloat()`

Dato che -1 appartiene al dominio dei numeri che possono essere restituiti dai metodi di `DataInputStream`, è necessario fare il catch dell'eccezione `EOFException`.

# Stdin, Stdout, Stderr
In Java si accede ai tre stream standard con:
- `(static) System.in` rappresenta il dispositivo di standard input ed è di tipo *InputStream* (a caratteri, perchè prima non esisteva `Reader`). Conviene comporre un `BufferedReader` con `System.in` in ingresso, che offre `readLine()`. Solitamente si applica anche il filtro `InputStreamReader`, prima del `BufferedReader`, che converte byte in caratteri.
- `(static) System.out` bindato a standard output.
- `(static) System.err` bindato a standard error.

## Sottoclassi di OutputStream
### ByteOutputStream
Il buffer di output è un array di byte; dinamicamente espandibile.
Il buffer può essere in due modi diversi:
- `toByteArray()`
- `toString()`
### FileOutputStream
Scrive i dati verso un `File` o un `FileDescriptor`
## Sottoclassi di FilterOutputStream
- `PrintStream` per stampare sotto forma di stringa i tipi primitivi
- `DataOutputStream` per scrivere in binario i tipi primitivi
- `BufferedOutputStream` per la scrittura bufferizzata

# Serializzazione
Si usano filtri `ObjectInputStream` con metodo `readObject()` e `ObjectOutputStream()` con `writeObject()`

Chiamando `writeObject()` la serializzazione può essere ricorsiva, se in un oggetto viene mantenuto un riferimetno ad un'altro oggetto. La **serializzazione ricorsiva** viene chiamata anche serializzazione in profondità (**deep**).

Serializzare un oggetto può quindi comportare la serializzazione di un interno grafo di oggetti. Nel caso di cicli non viene serializzato due volte lo stesso oggetto, ma in modo intelligente viene aggiunto solamente il riferimento ad esso.

Gli oggetti serializzabili devono implementare l'interfaccia `Serializable`.

Esempio scrittura:
```java
ObjectOutputStream os = null;
try {
	os = new ObjectOutputStream(file);
	os.writeObject(obj);
	os.flush();
	os.close();
}
catch (IOException e) {
	System.exit(2);
}
```

Esempio lettura:
```java
List x = (List)(is.readObject());
```

I campi **transienti**, etichettati con la parola chiave `transient`,  non verranno serializzati.

# Reader e Writer
La lettura di un carattere avviene attraverso il metodo `read()` che restituisce un intero di 4 byte, dove un valore tra 0 e 65535 rappresenta una buona lettura di un carattere, mentre -1 ci indica che lo stream è finito.

Esempio:
```java
int i;
char c;
i = in.read();
if (i != -1) {
	c = (char) i;
}
```

Il metodo `ready()` ci indica se lo stream ha caratteri pronti da essere letti.

## CharArrayReader
Equivalente di `ByteArrayInoutStream`, ma prende in ingresso un array di caratteri.

## InputStreamReader
È un caso particolare di reader che **reinterpreta** un `InputStream` come stream di caratteri (converte byte in caratteri) UTF-16.

### FileReader
Sottoclasse di `InputStreamReader` che legge caratteri da un file.

## BufferedReader
Come `BufferedInputStream` ma con i caratteri al posto dei byte (memorizzazione su buffer dei caratteri in ingresso).

Mette a disposizione il metodo `readLine()` che permette di leggere una riga di caratteri alla volta. È platform-dependent, quindi parsa correttamente il fine riga in base alla piattaforma su cui ci troviamo.

## FilterReader
È una classe astratta, senza metodi astratti. Non può essere istanziata.

## OutputStreamWriter
Conversione stream di byte in caratteri.
## FileWriter
Per scrivere caratteri su file.
## BufferedWriter
Aggiunge un buffer prima dello stream di caratteri.
Definisce il metodo `newLine()`, anch'esso platform-dependent.
## FilterWriter
Classe astratta capostipite dei filtri in scrittura.

# System
`System.in` e `System.out` sono effettivamente stream di caratteri; dovrebbero quindi appartenere alla classe `Reader` e `Writer`. In realtà sono definiti come `InputStream` e `PrintStream`, sottoclasse di `OutputStream`.
È stato fatto questo per mantere la compatibilità con Java 1.0, in cui `Reader` e `Writer` non esistevano.

```java
BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
try {
	Integer.parseInt(r.readLine());
}
catch (...) {
	...
}
```

Per convertire tipi primitivi in stringa, si usano:
- `Float.toString(f)`
- `Integer.toString(i)`
- ecc.

Attenzione: se il file che si cerca di aprire con `FileWriter` e `FileReader` un file che non esiste, esso viene creato. Una delle poche occasioni in cui questo non avviene, è quella in cui non si hanno i permessi di scrittura su una cartella.

Lo svantaggio della scrittura a caratteri è l'occupazione in termini di spazio: per salvare un numero a più cifre ho bisogno di più caratteri a 16 bit (uno per rappresentare ogni cifra); in più quando leggo una sequenza di caratteri che rappresentano interi, non so come tokenizzarli.

### Ciclo di lettura
```java
while (in.ready()) {
	// lettura
}
```

# Creazione classi filtro
Per creare una nuova classe filtro che manipoli dati, si:
- eredita da `FilterReader`
- prende in ingresso un generico `Reader`

Cosa implementare (dato che `Reader` è generico)?
- `public void close() throws IOException` -> conviene delegarlo a `reader.close()`
- `public int read(char b[], int off, int len)` -> si può delegare a `reader.read(b, off, len)`

# Scanner
Da Java 5 esiste la classe `Scanner` che permette di tokenizare una sorgente per convertire i token in tipi primitivi.
Esempio:
```java
Scanner s = new Scanner(System.in);
while (s.hasNext()) {
	// uso il token con s.next()
}
```

I metodi chiamabili sono:
- `nextInt()`
- `nextFloat()`
- ecc.

A differenza di `BufferedReader` vengono letti token e non righe.
Un'altra opzione a `Scanner` è `StreamTokenizer`, presente da Java 1.0