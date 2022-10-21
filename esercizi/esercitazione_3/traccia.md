# Esercitazione sull'ereditarietà
Hint: sapere cos'è il polimorfismo
Hint: una classe astratta non è istanziabile. Può avere comunque un costruttore, che non verrà mai invocato direttamente, ma attraverso `super()` da una sua sottoclasse.

Un package è un meccanismo per rendere modulare un software. Ogni package è una collezione di servizi (classi) standalone, logicamente divisi da quelli contenuti in altri package.

Si vuole implementare un insieme di classi che rappresentano le seguenti figure geometriche:
- triangolo
- triangolo rettangolo
- rettrangolo
- quadrato
- cerchio

Le proprietà comuni (area e perimetro) devono essere racchiuse nello stato della classe *Figura*

## Consigli
Attenzione: **overloading** diverso da **polimorfismo**

Il comportamento polimorfico si raggiunge se "una variabile nasce di un tipo e muore con un tipo diverso". Oppure se la variabile è di tipo "superclasse", mentre la variabile è di tipo "sottoclasse".

## Determinare classe di un oggetto
Si utilizza lo statement `instanceof`:
```java
OBJ instanceof CLASS
```

## toString
Qualunque oggetto in Java eredita da Object, che implementa un meotdo `toString`.

Questo metodo può essere sovrascritto con una stringa personalizzata in base alla classe corrente.

## Compilazione da riga di comando
Struttura classica:
- projname
	- src
	- bin
In *src* creo un *pkg*, ovvero una directory, che contiene anche *Main.java*

All'interno di *src* lancio `javac ./pkg/Main.java -d ../bin` per compilare.

Entro in *bin* e lancio `java pkg.Main` per eseguire il codice appena compilato. Il dot è un separatore che equivale a separare cartelle con "/".

## Jar
Ha il vantaggio di non dover distribuire decine di file .class
Posso eseguire un file jar con: `java -jar ./filename.jar`