# Objects under the hood

## Riferimenti
Supponendo `p1` e `p2` riferimenti ad un oggetto, l'assegnamento `p1 = p2` copia in riferimento contenuto in p2 all'interno di p1.

Attenzione: modificando p2 si ha un effetto collaterale su p1, perchè l'oggetto referenziato dai due puntatori è lo stesso.

Quindi non viene copiato l'oggetto.

## Copia di oggetti
```
Contatore p1 = new Contatore();
// Utilizzo di p1
Contatore p2 = (Contatore) p1.clone();
// p1 e p2 sono variabili (puntatore) che si riferiscono a due oggetti distinti
```

## Passaggio argomenti
I passaggi in Java avvengono sempre per copia. Non esiste il concetto di puntatore.

Questo non è limitativo, perchè passando una variabile riferimento si riesce ad accedere all'oggetto desiderato.

## Confronto oggetti
L'operatore `==` confronta gli indirizzi contenuti in due variabili riferimento.

Per questa ragione bisogna usare il metodo `.equals()` se si vuole confrontare il contenuto di due oggetti.

Es:
```java
p1 == p2  // true se puntano allo stesso oggetto; false se puntano a due oggetti differenti con lo stesso contenuto
p1.equals(p2);  // true se contenuto è lo stesso, indipendentemente dal riferimento
```

## Garbage collector
Componente della JVM che libera memotia re non è più accessibile; per esempio nel caso in cui si perdano tutti i riferimenti ad essa.

È possibile forzare un "delete" dell'area di memoria occupata da un oggetto con:
```java
Contatore c = new Contatore();
c = null;
```

## this
`this` &larr; keyword che indica l'oggetto stesso.

Serve per:
 - andare contro al mascheramento di un argomento (disambiguare), con lo stesso nome di un attributo, all'intero di un metodo di istanza
 - chiamare un altro costruttore della stessa classe (chiamare il costruttore con il nome della classe non è possibile):
  ```java
  public Contatore() { this(0); }
  ```