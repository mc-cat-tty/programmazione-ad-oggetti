
# Intro
Consigliato usare le strutture dati del package `java.util` perchè testate ed efficienti, nel caso estendere quelle di già presenti.

Implementano l'interfaccia:
- `Collection<E>` -> container di gruppi di elementi. Un tipo corrispondente ai valori degli elementi.
- `Map<K, V>` -> container associativi. Due tipi corrispondenti a chiave e valore.


`Collection<E>` implementa a sua volta l'if `Iterable<E>`

## Collection
L'interfaccia `Collection<E>` e serve a mantenere un gruppo di elementi lineari.

Può essere costruita a partire dal costrutture standard (ds inizialmente vuota), oppure a partire da un'altra collezione.

Metodi:
- `int size()`
- `boolean isEmpty()`
- `boolean contains(E ele)` (+ variante `All` con collection in ingresso)
- `boolean add(E ele)` (+ variante `All` etc.)
- `boolean remove(E ele)` (+ variante `All`)
- `Iterator iterator()`

## Map
Interfaccia `Map<K, V>` in cui le chiavi devono essere uniche. Associano chiave a valore.
Può essere costruita come vuota all'inzio o a partire da un'altra mappa.

Metodi:
- `V put(K key, V value)` -> restituisce il valore già associato alla chiave `key`, se la entry esiste già
- `V get(Object key)` -> ritorna il valore associato alla chiave
- `V remove(Object key)`
- contains
- keyset
- valueset
- size
- isEmpty
- clear

Esempio:
```java
Map<String, Person> people = new HashMap<String, People>();
```

# Collection
## List
Deriva da Collection ed aggiunge ad essa metodi per recuperare first e last index di un elemento e altri metodi simili.

### ArrayList
Si basa su array, ridimensionamento dinamico.

Get costante. Insert e cancellazione in testa Theta(n).

Esempio politica ridimensionamento:
- raddoppio quando raggiungo l'80% della dimensione allocata
- dimezzo quando scendo sotto il 20%
-> questa politica aumenta l'**isteresi** della struttura dati (inseriza rispetto a inserimento e rimozione)

### LinkedList
Si basa su una lista linkata (puntatori).

Get lineare. Inserimento e cancellazione in testa costante.

### Vector
Eredita da `List`. È come una `ArrayList`, ma thread-safe. È una struttura dati ad accesso più lento rispetto ad una `ArrayList`.
Il vector concentra al suo interno due comportamenti: lock + struttura.

La politica di ridimensionamento può cambiare nel tempo, il programmatore non deve basare il suo software su questo.

Questa struttura dati è obsoleta, ora si usa `synchronizedList` insieme alla keywork `synchronized`

## Set
Ogni elemento è unico, come se appartenesse ad un insieme matematico.

### SortedSet
Interfaccia che rappresenta un insieme ordinato (di default con ordine naturale degli elementi)

Gli oggetti che si vogliono ordinare devono essere conformi all'interfaccia `Comparable<T>` e implementare `compareTo(T)`.
Ma non sempre è possibile ridefinire la classe che si vuole contenere nel set.

Un'alternativa fornita da Java consente di usare un comparatore esterno.
Agli oggetti di questa classe (o sue sottoclassi) è possibile passare un oggetto con interfaccia `Comparator c` che stabilisce l'ordinamento degli elementi del set, nel caso in cui lo si voglia diverso da quello naturale. 

```java
public class StudenteComparator implements Comparator<Studente> {
	public int Compare(Studente s1, Studente s2) {
		return s1.getMatricola() - s2.getMatricola();
	}
}
```

#### TreeSet
Sorted set che mantiene l'ordinamento con un albero bilanciato.

### HashSet
mantiene una tabella hash.

#### LinkedListHashSet
Gli elementi sono scorsi rispetto all'ordine di inserimento.

# Map
Sono strutture dati associative, non sequenziali.

## SortedMap
Interfaccia che rappresenta una mappa ordinata per chiave, con ordine naturale.

### TreeMap
Implementazione di `SortedMap` che usa un albero come struttura interna.

## HashMap
Implementazione di  `Map` che non mantiene un ordine particolare

### LinkedHashMap
Gli elementi sono scorsi rispetto all'ordine di inserimento

# Iterator
```java
Iterator<E>
```

Interfaccia che fornisce un modo uniforme e trasparente per scorrere una struttura dati, indipendentemente dalla sua implementazione.

Bisogna implementare i metodi:
- `boolean hasNext()`
- `E next()`

Da Java 8 esistono anche:
- `default void remove()`
- `default void forEachRemaining(Consumer<? super E> action)`

>A partire da Java 8 è stato inserito il concetto di **default methods** -> posso definire il corpo di un metodo all'interno di un'interfaccia

Scorrimento ds iterabile:
```java
while (ds.hasNext()) {
	var v = ds.next();
	System.out.println(v);
}
```

## BestPractices
È pericoloso modificare una struttura dati su cui si sta iterando -> risulati imprevedibili.

La cosa migliore è usare metodo come `add()` e `remove()`:
- `Iterator.remove()`
- `ListIterator.add()`

# Algoritmi
## Collections
La classe `java.util.Collections` (attenzione: non è l'if `Collection`) mette a disposizione una serie di algoritmi generici per lavorare sulle liste.
Questi algoritmi sono forniti tramite metodi statici:
- `sort( merge sort, nlog(n)
- `binarySearch`
- `shuffle`
- `reverse`
- `rotate`
- `min` e `max`

## Arrays
La classe `java.util.Arrays` mette a disposizione degli algoritmi per lavorare specificatamente con gli Array (sempre tramite metodi statici):
- `sort`
- `binarySearch`
- `compare`
- `copyOf`
- `equals`

Esempio:
```java
// Ordinamento di una lista di studenti in ordine naturale
List<Studente> studenti = new ArrayList<Studente>();
Collections.sort(studenti);
```