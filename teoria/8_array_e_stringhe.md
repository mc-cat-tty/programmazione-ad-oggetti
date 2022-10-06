# Array e Stringhe in Java

## Intro alle Stringhe
L'array di caratteri terminato da '\0' è wrappato dall'oggetto `String`.

Gli oggetti di tipo _String_ sono *immutabili*. È necessario usare uno _StringBuffer_ nel caso.

La dichiarazione di un oggetto di tipo string prevede: `String s = new String("ciao")` ma è possibile fare anche `String s = "ciao"`

### Operazioni

La *concatenazione* è possibile attraverso l'operatore `+`. Quando possibile (stringhe costanti o literal) la concatenazione avviene a tempo di compilazione. Questo stesso operatore converte automaticamente variabili numeriche in stringhe.

### Metodi
- `char charAt(int index)`
- `boolean endsWith(String suffix)`
- `boolean beginsWith(String prefix)`
- `boolean equals (Object other)`

Attenzione: usa sempre l'equals non `==` (confronta locazione memoria) per comparare il contenuto dell'oggetto `String`

- `String substring(int beginIndex)`
- `String substring(int beginIndex, int endIndex)`
- `int length()` come `strlen(char *)`
- `String toLowerCase()`
- `String toUpperCase()`

## Array
Gli array sono implementati internamente come una classe, ma non serve creare un'istanza di un certo oggetto. A differenza delle altre variabili sono distinti da parentesti quadre.

Il *campo* `length` contiene la dimensione dell'array.

Sequenza di elementi omogenei.

```java
int[] a1 = {8, 10, 12};
int[] a2;
a2 = new int[5];  // posso allocare l'area di memoria dopo aver dichiarato la variabile

System.out.println(a1.length);
```

Gli array di oggetti vengono inizializzati a _null_ quando li creo con `new`

Attenzione: quando ho array di oggetti, ogni locazione va riempita con un riferimento ad un oggetto diverso.