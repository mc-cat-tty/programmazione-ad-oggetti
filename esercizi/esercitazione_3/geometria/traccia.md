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
