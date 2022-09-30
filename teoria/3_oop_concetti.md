# Caratteristiche della OOP

1. Incapsulamento
2. Ereditarietà
3. Polimorfismo
4. Introspezione

## Incapsulamento
Dati e codice cooesistono all'interno della stessa entità.

L'oggetto protegge i dati verso l'esterno, solo i suoi metodi conoscono come manipolarli.

Gli utilizzatori esterni accedono ad essi tramite un'interfaccia.

Lo *stato* di un oggetto è l'ìinsieme delle variabili, sia primitive che per riferimento (altri oggetti), contenute in esso.

## Ereditarietà
Una classe può *estendere* o *specializzare* un'altra classe, ereditandone variabili e operazioni.

Può essere così stabilita una gerarchia delle classi, che presuppone l'esistenza di una radice dell'albero (superclasse).

Vantaggi:
 - stabilisco una gerarchia
 - riutilizzo il codice

## Polimorfismo
Una entità può esprimersi in diverse forme a seconda di una condizione variabile:
 - parametri passati
 - contesto di esecuzione
 - oggetto che esegue l'operazione

## Introspezione
Capacità di un oggetto di auto-esaminarsi e modificarsi runtime. Da "meta" (= qualcosa che sta sopra).

Vedi _instrospection_ e _reflection_ di Java.

## Linguaggi ad oggetti puri
Non sono estensioni di linguaggi non OOP, come il C++.

- SmallTalk
- Eiffel
- Java
- C#

## Vantaggi
- Facilitano lo _sviluppo cooperativo_ &rarr; ogni classe può essere assegnata ad uno sviluppatore diverso.
- Necessario conoscere le interfacce, ma non l'implementazione
- Gli errori che causano un malfunzionamento di una classe, si trovano sicuramente all'interno di quest'ultima
- Le modifiche di una classe non rendono necessario modificare il resto delle classi
- Sviluppo _incrementale_ grazie all'ereditarietà
- _Prototipazione rapida_ attraverso la definizione dell'interfaccia, con implementazione vuota

## Difficoltà
La difficoltà nella programmazione ad oggetti si riduce alla scelta della giusta granularità.

