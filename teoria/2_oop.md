# Programmazione ad oggetti

## Vantaggi della protezione dati
- controllo plausabilità incluso nell'entità
- il check viene codificato una volta per tutte, è compito del setter e non dell'utilizzatore
- più facilmente modificabile

## Incapsulamento
Nello stesso oggetto si trovano sia lo stato, ovvero l'insieme delle variabili, che l'interfaccia, ovvero l'insieme di funzioni che esportano dei servizi, che rappresentano gli oggetti di quella classe.

## Modello
Le classi vengono definite *staticamente* dal programmatore, gli oggetti verranno allocati *dinamicamente* in base alla richiesta.

Il modello utilizzato è quello _client-server_, un modello asimmetrico che presuppone l'inizio della "comunicazione" (richiesta di servizio) da parte del client e l'esposizione dei servizi/metodi da parte dell'oggetto. In generale il server fornisce e il client consuma.

Utilizzeremo la notazione punto per *invocare* i metodi: `Obj.Service`

## Vantaggi
Il client non conosce l'implementazione interna del fornitore del servizio, ma usufruisce delle funzionalità esposte attraverso un'interfaccia.

Client e server sono disaccoppiati.

## Terminologia
- semantica per _riferimento_ che rimuovono i tanti errori dovuti all'uso di puntatori
- concetto di _ambiente_ (SmallTalk)

## Astrazione tramite classi
Ogni classe raggruppa attributi e metodi che caratterizzano un insieme di oggetti, classificati come appartenenti alla stessa classe perchè condividono gli stessi comportamenti.

Un oggetto è un'istanza di un classe.

La dipendenza classe - oggetto perdura per tutto il periodo di vita dell'istanza. L'istanza valorizza gli attributi definiti in modo astratto dalla classe.

_Variabile di istanza_ = è un attributo *posseduto* (come copia) da tutte le istanza di una stessa classe.

_Variabile di classe_ = attributo *condiviso* da tutte le istanze della classe.

Anche i metodi possono essere di classe o istanza.

Individuare il _dominio applicativo_

## Rappresentazione delle dipendenze tra classi
UML - Unified Modeling Language

## Memoria
A differenza delle variabili e strutture in C, gli oggetti vengono allocati e deallocati all'esigenza.

