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

