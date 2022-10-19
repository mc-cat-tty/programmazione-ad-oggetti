# Keywords in Java

## Knowledge Links
[[10_package]] [[6_opertori_e_costrutti]] [[5_variabili]]

## Variabili di classe
Le variabili di classe sono visibili (condivise) da tutti gli oggetti della stessa classe. Vengono definite attraverso il modificatore `static`.

Es: contare tutti gli oggetti istanziati di una classe

## Metodi di classe
Preceduti dal modificatore `static`. Possono essere invocati senza istanziare un oggetto, quindi direttamente sulla classe.
I metodi di classe possono accedere solo alle variabili di classe.

Es: metodo main (entry-point del programma)

## Libreria _Math_
Tutti i metodi di questa libreria sono statici, perchè non interagiscono con nessun oggetto; il loro compito è quello di trasformare un input in un certo output.

Contiene due costanti: `E`, `PI`

## Costanti
Le costanti sono variabili etichettate con `final`. Queste vars non possono cambiare valore durante l'esecuzione.
Spesso le costanti sono anche statiche.

Attenzione:
```java
float f = 1.0;  // Erorre perchè il literal 1.0 è considerato dobule
float f = 1.0F;  // OK
```

## Ordine modificatori
```java
[access] [static] [final] type varname [= value];
```

_Overloading_ = più metodi con lo stesso nome, ma argomenti diversi.
_Overriding_ = dare la precedenza ad un metodo più specifico (da _override_)
