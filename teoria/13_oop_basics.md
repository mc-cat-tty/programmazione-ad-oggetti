# OOP Basics

## Incapsulamento
All'interno di una classe Java si trovano metodi, variabili e possono trovarsi altre classe (**nested class** o **inner class**).

Java è un linguaggio interamente orientato agli oggetti e, come tale, i metodi possono essere definiti solo all'interno di una classe.

Racchiudo stato e servizi in un unico oggetto. Servizi tipici possono essere getter e setter. Solitamente dentro ai setter si trovano tutti i controlli di plausibilità del caso.

## Visibilità
- private: nascosto agli utilizzatori
- public: visibile a tutti
- (friendly): visibile alle classe dello stesso package
- protected: visibile alle classi figlie e alla classi dello stesso package

I metodi possono avere tutti e quattro i tipi di visibilità; le classi possono essere solo (friendly) o protected.

Vedi: enterprise java beans

## Ereditarietà
Tutte le classi in Java ereditano da `Object` che ha metodi con implementazione di default come `String toString()`. Questo metodo viene chiamato in automatico quando si vuole concatenare l'oggetto stesso con una stringa, oppure lo si vuole stampare.

Priblema: aggiungere funzionalità (estendere) una classe già esistente con nuove funzionalità.

_Boilerplate (code)_ = codice che non aggiunge logica all'applicazione, ma è necessario al funzionamento del software.

## Soluzione 1: Composizione
Creare una nuova classe che memorizzi un riferimento alla classe da estendere. Svantaggioso a meno che non si ritorni l'oggetto base.


## Soluzione 2: Ereditarietà
= caratteristica della OOP che permette di aggiungere variabili e metodi a classi già esistenti.

L'ereditarietà è monotona, non posso rimuovere servizi o variabili di stato.

## Caratteristiche
Ereditarietà singola: posso ereditare da una sola classe alla volta con la keyword `extends`. L'ereditarietà multipla non è permessa; posso invece implementare più interfacce diverse.

Attenzione: eredito tutti i metodi e le variabili di una classe, _tranne_ i costruttori; non tutti sono visibili. 
Attenzione: i costruttori non sono soggetti all'ereditarietà

La gerarchia di classi è concessa (a cascata).

Ereditarietà monotona: (vedi prima)

Posso fare **overriding dei metodi** nella classe figlia.

## Terminologia
Superclasse, classe padre, classe base.

Classe figlio, classe derivata, ...

## Rappresentazione
Diagramma UML - Unified Modelling Language

## Costruttore
Il costruttore di default viene dichiarato implicitamente dichiarato dal compilatore.

Attenzione: può capitare che il costruttore di default non sia presente 

## super
La keyword `super` può essere usata per:
 1. chiamare il costruttore della classe padre. In questo caso deve essere essere la prima istruzione chiamata.
 2. accedere a variabili della superclasse. Disambiguare in caso di mascheramento. Ad esempio quando dichiaro una variabile con lo stesso nome di una var presente nel padre

Non è possibile risalire al nonno con la notazione super.

## Annotazioni
`@Override` indica al compilatore che voglio fare l'override di un metodo (mi segnala se il metodo non esiste nella classe base).

Grazie alla redifinizione dei metodi riesco a raggiungere il polimorfismo.

