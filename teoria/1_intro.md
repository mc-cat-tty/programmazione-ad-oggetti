# Lezione introduttiva

## Storia

1600
: Pascalina - simile ad una calcolatrice meccanica

1900
: A. Turing inventa il primo computer programmabile


Linguaggi procedurali &rarr; strutturati &rarr; orientati ad oggetti

## Rappresentazione delle informazioni
Si cerca di minimizzare la distanza tra messaggio interno e messaggio esterno, se esso è definito dall'uomo e non stabilito dal mondo reale/ambiente circostante.

Compiti del programmatore sono minimizzare la "distanza di astrazione" (sforzo concettuale), minimizzare la complessità computazionale (sforzo algoritmico) e minimizzare la complessità progettuale (sforzo di produzione e mantenimento del software).

## Caratteristiche del software desiderato
1. protetto: evitare che parti di programma insicuro/errato influiscano su altre parti del programma
2. riusabile: riutilizzare i moduli già scritti
3. documentato: per facilitare la manutenzione
4. modulare: dividere logicamente le funzionalità del programma e gestirle in modo separato/indipendente
5. estendibile: aggiungere funzionalità in modo incrementale

## Svantaggi della programmazione tradizionale
*Crisi dimensionale* &rarr; difficoltà a gestire software di grandi dimensioni
*Crisi gestionale* &rarr; difficoltà a mantenere il software

- difficoltà modifica
- impossibile protezione variabili
- modifica funzioni e inconsistenza con le ds

Vedi _Code Complete_ di Steve McConnell.

"Cleanroom development" &rarr; metodologia di sviluppo verso la riduzione degli errori nel codice

Suddividendo un progetto in moduli evito che l'errata manipolazione di un variabile, per esempio, si propaghi in tutto il progetto. In questo caso l'errore si propagherà solamente all'interno del modulo. Ancor meglio nel caso della programmazione ad oggetti, in cui i costrutti del linguaggio e il compilatore mi permettono di *incapsulare* attributi (dati) e metodi (operazioni, funzioni) all'interno di uno stesso oggetto.

## Vantaggi dell'astrazione di dato
- agevola la *modularità* incapsulando dati e funzioni che lavorano su essi
- favorisce l'*integrità* attraverso la verifica di plausibilità dei dati e la protezione degli attributi privati
- creazione di componenti autonomi
- diminuisce la *distanza* tra l'oggetto astratto e quello concreto

ADT - Abstract Data Type

## Classi di variabili in C
- auto
- register
- static
- extern

Potremmo implementare un ADC in c utilizzando una variabile privata (statica) all'interno di un modulo e definendo una serie di funzioni che accedono a questo dato. 