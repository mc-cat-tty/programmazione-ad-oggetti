# Il linguaggio Java
Inventato da SUN Microsystem per la programmazione dei PDA. 

## Famiglie di linguaggi
- imperativi: C, Python, Java, ...
- funzionali: LISP &rarr; tutto viene espresso come funzioni matematiche
- logici: Prolog &rarr; descrizione attraverso input - target

## Caratteristiche del Java
- *fortemente tipizzato*
  A differerenza del C, in cui il tipo definisce la dimensione dell'area di memoria, le operazioni che si possono eseguire, 
- ad oggetti
- *interpretato*
- *portabile*: il bytecode può essere eseguito attraverso la JVM su qualunque architettura

### Gestione della memoria
Esistono due filosofie di pensiero, entrambe partono dal presupposto che la gestione della memoria è troppo importante per essere lasciata al programmatore.

Linguaggi come il C risolvono questo problema lasciando il pieno controllo al programmatore.

Linguaggi come Java e SmallTalk gestiscono implicitamente la memoria: keyword *new* e deallocazione fatta dal *garbage collector*

Grazie al garbage collector evito dangling reference, memory leak, invalid reference, ...

## Ambiente di sviluppo
- `javac` compilatore
- `java` interprete
- `jdb` debugger
- `appletviewer` visualizzatore applet

## Librerie standard
AWT, Swing, RMI, Socket

## Edizioni e versione Java
- JME - Java Micro Edition
- JSE - Java Standard Edition &larr; useremo questa
- JEE - Java Enterprise Edition

La versione del linguaggio Java è un tasto dolente. Ogni 6 mese una nuova versione.
Noi useremo una versione superiore alle 11. Attualmente siamo alla 19.

