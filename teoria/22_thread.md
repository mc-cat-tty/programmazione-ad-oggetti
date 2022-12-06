# Processi
Un processo è un'istanza in esecuzione di un programma (immagine - eseguibile). Ne deriva che più processi di una stessa immagine possono essere in esecuzione contemporaneamente.
Ogni processo è isolato e indipendente dagli altri: spazio di indirizzamento privato.

# Thread
Ogni processo può eseguire più thread in maniera concorrente. Il thread è l'unita minima a cui la CPU concede tempo macchina.

Ogni thread **ha un proprio stack privato** (riservato, indipendente dagli altri thread) e uno **spazio di indirizzamento condiviso** con gli altri thread generati dallo **stesso processo padre**.

La comunicazione tra più thread (*interthread communication*) avviene tramite lo spazio di memoria condiviso; in particolare attraverso **varibili globali** o **aree di memoria comuni**, il cui riferimento viene passato ai vari thread.

Serve regolare (*disciplinare*) l'accesso a tali varibili con **meccanismi di sincronizzazione** -> gli altri thread dello stesso processo potrebbero accedere contemporaneamente alle stesse variabili (operazioni non atomiche, race condition, ecc.)

Nei linguaggi di programmazione ad oggetti, non ha senso il concetto di **variabile globale**.
Due o più thread possono comunque condividere un riferimento ad uno stesso oggetto -> condivisione dati, interazione tra Tn e Tm, scambio risultati della computazione, ecc.

# Scheduling
Un S.O. multitasking assegna un quanto di tempo CPU (*timeslice*) ad un certo processo secondo un thread secondo una certa politica.

>preemptive = pre-rilascio

Le politiche di scheduling si suddividono in:
- **preemptive** le politiche con pre-rilascio possono togliere la CPU ad un thread
- **cooperative** tutti i task sono strutturati in modo da rilansicare la CPU durante la loro vita, così da lasicare del tempo macchina per gli altri. L'operazione si chiama **yield** o **sleep**

L'illusione del parallelismo è data assegnando timeslice molto piccoli e alternando l'esecuzione.

La JVM, e di conseguenza il nostro programma, è eseguita come processo del SO. In base all'implementazione ogni thread viene mappato in un thread del sistema operativo, gestitio quindi dal suo scheduler.

Non è garantita nessuna politica di scheduling in particolare.

# Thread in Java
I thread in Java sono degli oggetti della classe `Thread` che espongono il servizio `start()`, il quale li fa partire in parallelo. `start()` può essere invocato una sola volta, pena il sollevamento di una `RuntimeException`. Quando questo metodo viene chiamato il thread invocato esegue in parallelo al thread chiamante.

Le uniche garanzie che il SO offre sono che:
- il thread venga avviato quando `start()` viene chiamato
- il thread termini a meno di race condition o deadlocks

Questo perchè lo scheduler potrebbe decidere di toglere il thread dalla cpu per eseguire un'altro; una o più volte.

## Sottoclasse di Thread
Il nocciolo di questa classe è il metodo `run()`, che deve essere reimplementato per personalizzarne il funzionamento.

```java
class MyThread extends Thread {
	@Override
	public void run() {
		// concurrent code
	}
}

// ...

MyThread t = new MyThread();
t.start();
```

## Oggetto Runnable
In alternativa si può costruire un oggetto `Thread` passando al costruttore un oggetto conforme `Runnable`, che richiede l'implementazione di un metodo `run()`.

```java
class ConcurrentService implements Runnable {
	@Override
	public void run() {
		// concurrent code
	}
}

// ...

Thread t = new Thread(new ConcurrentService());
t.start();
```

Questo metodo è più flessibile.

## Errori di sincronizzazione
### Deadlock
È una situazione di stallo che avviene, nel suo caso più semplice, quando due task utilizzano due risorse diverse, protette da lock, per svolgere i loro compiti.
Se T1 richiede R1 (che riesce ad ottenere) e R2 per continuare l'esecuzione, ma T2 ha in mano R2 e a sua volta necessita anche di R1, si ha uno stallo.

### Livelock
Nel livelock entrambi i processi non sono stallati, ma eseguendo in modalità interlacciata, quando T1 rilascia R2 nella speranza che T2 possa continuare l'esecuzione, T2 rilascia R1 con la stessa speranza e viceversa durante i turni pari.

### Resource Starvation
È una forma di DoS in cui ad un task non viene mai concesso l'uso di una risorsa, bloccando di fatto per sempre la sua esecuzione.

Vedi: differenza tra spinlock (lock che spinna quando non riesce ad ottenere una risorsa) e sleeplock (lock che mette il task in sleep se la risorsa non è libera)

## Thread FSM
La macchina a stati che regola in funzionamento dei thread in Java è la seguente:
1. il thread appena creato è nello stato **new** (non **alive**)
2. appena in thread viene fatto partire con `start()` va nello stato **runnable** (**alive**)
3. si alterna tra **running** e **runnable** in base al volere dello scheduler (**alive**)
4. quando `run()` termina il thread va in **dead** (non **alive**)

Al punto 3 possono alternarsi anche gli stati:
- **waiting** se il thead attende un lock con `lock.wait()` da cui esce quando riceve una notifica
- **blocking** quando attende di poter accedere ad una *guarded resource*
- **sleeping** se messo in sleep dall'esterno con `Thread.sleep()`

![[Screenshot_20221205_122348.png]]

Un thread può volontariamente lasciare lo stato *running* invocando:
- `sleep()`
- `yield()` fornisce un hint allo scheduler che il thread non sta facendo niente di utile, quindi può lasciare la CPU. Lo scheduler è libero di ignorare questo hint, per esempio perchè potrebbero non esserci thread in runnable con priorità più alta. Viene usato per implementare il **coroutining**, quindi lo scheduling senza preemption.
- `join()` per sincornizzarsi con l'esecuzione di altri thread.
	```java
	Thread t = new Thread();
	t.start();
	// do sth in the main thread
	t.join();  // suspends the main thread and waits until t terminates
	// OPPURE
	t.join(5000);  // adds a timeout (ORed condition)
	```

Questi tre metodi sono statici -> influenzano l'oggetto chiamante. Su un thread non possono essere chiamati questo metodi dall'esterno (almeno non con il risultato desiderato). 

## Priorità
Ad ogni thread è assegnata una priorità. Normalmante viene **ereditata** dal thread che lo avvia. È un intero non negativo tra 1 e 10:
- `Thread.MIN_PRIORITY (1)`
- `Thread.NORM_PRIORITY (5)`
- `Thread.MAX_PRIORITY (10)`

Come impostare la priorità?
```java
auto t = new Thread();
t.setPriority(5);
t.start();
```

Lo scheduling adottato dalla JVM non è standardizzato, siccome si appoggia allo scheduler del SO.
Di norma: scheduling time-sliced, preemptive, priority-based

## Sincronizzazione
Problema: una race condition può portare alla **corruzione di dati**
Obiettivo: rendere una serie di operazioni **atomica**, ovvero non interrompibile dallo scheduler

Java mette a disposizione la keyword `synchronized` a livello di metodo o di blocco di codice.
Ogni object ha un lock built-in, che viene acquisito quando si entra nel blocco di codice sincronizzato. Se due blocchi di codice sono sincronizzati sullo stesso oggetto, il secondo non può esegure finchè il lock sull'oggetto protetto non è **rilasciato**.

Attenzione:
- un blocco di codice può acquisire più lock, per esempio con `synchronized` annidati
- `sleep` non rilascia il lock di un oggetto

Utilizzo:
```java
public synchronized void doStuff() {
	// resource access
}

// OPPURE (equivalentemente)

public void doStuff() {
	synchronized(this) {
		// resoruce access
	}
}
```

Una classe viene detta **thread-safe** se garantisce la coerenza dei dati anche a fronte di accessi concorrenti. Un esempio di classe thread-safe è `Vector`; ma non `ArrayList`.

### Wait e Notify
Solamente all'interno di blocchi `synchronized` è possibile chiamare `wait` e `notify` (o `notifyAll`)

`wait` sospende il thread in cui viene chiamato. Rilascia il lock sull'oggetto.
`notify` risveglia un thread in attesa. `notifyAll` risveglia tutti i thread in attesa.
Questi due metodi servono per implementare modelli produttore/i-conumatore/i con code di oggetti prodotti (e quindi da consumare).

Esempio produttore-consumatore con contenitore unitario:
```java
public class Contenitore {
	private int contenuto;
	private boolean contenutoDisponibile = false;

	public synchronized getContenuto() {
		while (contenutoDisponible == false) {
			try {
				wait();
			}
			catch (InterrupteException e) { }
		}
		contenutoDisponibile = false;
		notifyAll();
		return contenuto;
	}

	public synchronized putContenuto(int contenuto) {
		while (contenutoDisponibile == true) {
			try {
				wait();
			}
			catch (InterruptedException e) { }
			this.contenuto = contenuto;
			contenutoDisponibile = true;
			notifyAll();
		}
	}
}
```