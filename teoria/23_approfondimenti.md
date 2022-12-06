# Try with resources
https://docs.oracle.com/javase/tutorial/essential/exceptions/tryResourceClose.html

```java
try (
	File f = new File("path");
	FileFeader fr = new FileReader(f);  // open resources
) {
	// use resources
}
catch (RunTimeException e) {
	// manage exception
}
finally {
	// finalize operation
}
```

> Il blocco *finally* esegue sempre, anche se si verificano degli errori. Solitamente contiene le procedure di **clean-up**.

Con questa nuova sintassi, introdotta a partire da Java SE 7, le risorse aperte dentro le tonde del *try* vengono liberate automaticamente prima di uscire dal costrutto.

# var
A partire da Java 10 è stata introdotta l'inferenza di tipo con il costrutto `var` che rende superfluo specificare il tipo di dato di una variabile, a patto che essa venga inizializzata con un costruttore non nullo.

Gli usi più tipici comprendono:
- inizializzazione di variabili
- cicli for-each
- indici in cicli for classici

## Inizializzazione
```java
var file = new File("path")
var fileReader = new FileReader(file);
```

## Cicli for-each
```java
List<Integer> list = new LinkedList<String>(
	Arrays.asList(
		1,
		2,
		3,
		4
	)
);

for (var str : list) {
	// do something
}
```

## Classic for
```java
for (var i = 0; i < 10; i++) {
	// access array in position i
}
```

# Enum methods

# Streams

# Tags