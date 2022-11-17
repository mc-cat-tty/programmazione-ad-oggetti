# Autoboxing e Outboxing

> **Autoboxing**: una variabile di tipo primitivo viene convertita in un oggetto wrapper dello stesso tipo, se necessario

>**Outboxing**: processo inverso -> un oggetto wrapper di tipo Integer, Float o Double viene convertito nel rispettivo tipo primitivo se necessario

# For each
Non devo gestire l'indice di scorrimento. Si applica alle strutture dati lineari, in generale deve implementare l'interfaccia `Iterable`.

```java
for (variable_type varname : list) {
	// code
}
```

La variabile che uso nel foreach è locale, può essere usato solo come ciclo di **estrazione**, ma non di **assegnamento**.

# Type-safety
Problema: garantire a tempo di compilazione la coerenza dei tipi di dato usati, rendendo un algoritmo (o in generale un metodo/classe) generico.

Il controllo avviene sicuramente a run-time, ma potrebbe essere troppo tardi, in quanto causerebbe un crash del programma quando già distribuito.

Con i **generics** mi assicuro che il tipo passato appartenga ad una certa classe o ad un suo sottotipo.

### Esempio
Devo costruire un archivio omogeneo, in grado di mantenere una lista di studenti o di professori, due entità che hanno alcune proprietà in comune.

Fattorizzo queste due classi come discendenti di `Persona`. Grazie alla regola di conformità, accettando il supertipo `Persona`, accetterò contemporaneamente sia `Studente` che `Professore`.

Se cerco di castare un oggetto di tipo `Studente` al tipo `Professore`, accettato perchè discendente di `Persona`, il programma va in run-time error.

Possibili soluzioni:
- usare diverse interfacce in base al tipo che si vuole gestire -> scavalcabile
- memorizzare in tipo gestito, memorizzandolo nel costruttore e controllando che il tipo dell'elemento passato sia coerente all'interno di ogni metodo -> codice aggiuntivo, devo segnalare un errore per comunicare che il tipo è sbagliato
- creare una classe spacializzata per ogni tipo di persona che si vuole gestire -> codice duplicabile e poco scalabile
- eliminare la superclasse `Persona` -> soluzione non OOP

Java introduce i **generics** che sfruttano il compilatore per il controllo di tipo.

## Generics
Con i generics si preserva la generalità degli algoritmi implementati, ma si assicura la type-safety (coerenza dei tipo) a tempo di compilazione.

Vedi: PPPJ conference

```java
public class Archivio<T> {
	// ...
	public T get(int idx) { ... }
	public void add(T element) { ... }
}
```

Parametrizzo la classe `Archivio`. Utilizzo:
```java
var archivio = new Archivio<Studente>();
```

I generics ammettono l'uso di **wildcard**:
```java
<? extends type>
```

Nel caso dell'esempio di `Studente`, `Persona`, `Professore` farò:
```java
<T extends Persona>
```

Oppure anche:
```java
<? super type>
```

### Type erasure
A tempo di compilazione il tag generico viene rimosso, sostituendo il tipo generico con quello passato nelle parentesi angolari. Nel momento in cui viene utilizzato, il compilatore lo rimuove (nel codice della translation unit), poi aggiunge il cast prima all'interno di ogni chiamata.

Esempio:
```java
public class Archivio<T> {
	public T get(int idx) { ... }
}
```
Viene tradotto in:
```java
public class Archivio {
	public Persona get(int idx) { ... }
}
```

Mentre:
```java
var archive = new Archivio<Professore>();
archive.set(prof);
```
Diventa:
```java
var archive = new Archivio();
archive.set((Professore)prof);
```

Attento: la classe `String` è dichiarata come final, non esistono sue sottoclassi

Due classi parametrizzate diversamente risultano di **tipo diverso**

### Molteplici tipi parametrici
```java
public class HashTable<TK, TV> { ... }
```

### Estensione
```java
public class HashTablePersone<E,R> extends Archivio<E> { ... }
```

