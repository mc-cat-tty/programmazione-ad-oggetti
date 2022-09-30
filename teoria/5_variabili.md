# Le variabili in Java

## Tipi di dato
  - primitivi
    semantica per valore. byte, short, int, long, ...
  - riferimento
    soggetto di una classe referenziato da una variabile. _null_ nessun puntatore.

## Dimensioni
| nome | dim [bits] | descrizione |
|:---:|:---:|:---:|
| byte | 8 |  |
| short | 16 |  |
| int | 32 | dimensione "standard" data dalla JVM;<br>non più la dimensione di una parola come in C |
| long | 64 |  |
| float | 32 | IEEE754 single precision |
| double | 64 | IEEE754 double precision |
| char | 16 | UNICODE |
| boolean | 1 | true o false |


I caratteri vengono rappresentati come UNICODE, retrocompatibile con la codifica ASCII a 7/8 bit

## Assegnamento
`l_val = r_val`

È lecito `a = (b = val)`

## Cast
```java
Type1 A;
Type2 B;
A = (Type2) B;
```

Il cast non trasforma il tipo delle variabili, ma le reinterpreta. Potrebbe portare alla perdita di informazione se si passa da una risoluzione maggiore ad una inferiore.

> attento alle divisioni tra letterali

## Operatori aritmetici
- soliti
- %
- ++
- \-\-