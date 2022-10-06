# Package

Sono contenitori logici (es: widget dello stesso tipo) di classi, esattamente come le librerie (o sottolibrerie).

Ogni package ha una directory corrispondente nel fs, con lo stesso nome del package, e un file .class associato.

Esempio: creiamo un package `utilita` che contenga `Contatore` e `Data`. Accedo con `utilita.Contatore` o `utilita.Data`.

Con Swing: `javax.swing.JFrame f = ...`

## Import di un package
Equivale a `using namespace` in C++

Facendo `import javax.swing` posso usare i metodi di questo package come `JFrame`.

Le *wildcard* sono accettate `*`, molto conveniente nel caso si usino tutte le classi di un package: `import javax.*`

`java.lang` è importato di defualt e contiene le classi base come `String`.

L'import agisce solo come alias, non copia il contenuto di un file come la direttiva `#include` in C/C++