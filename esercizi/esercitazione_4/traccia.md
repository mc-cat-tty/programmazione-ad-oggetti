# Esercitazione su I/O binario
Useremo la teoria su gestione delle eccezioni e package io.
Eccezioni? Il SO potrebbe vietare l'apertura di un file perchè non si hanno i permessi, oppure perchè non esiste.
Le eccezioni esistono per gestire errori che capitano a runtime.

Per questo esercizio si creino due funzioni statiche all'interno della classe `Main`.

## Esercizio 1
Creare un programma Java che imiti in comportamento del comando UNIX `cp`: prendendo in ingresso da riga di comando il nome di due file, deve copiare il contenuto binario del file sorgente all'interno del file di destinazione.

Creare un oggetto file non significa creare un file.
Vedi `file.getAbsolutePath()`. Non usare separatore directory hardcoded -> rompe la crosscompatibility del pragramma. Usa `File.separator` e concatenalo al path.

Il blocco try definisce uno scope.

## Esercizio 2-3
Catch di più eccezioni nello stesso catch: `IOException | NumberFormatException e`.
Ricordati di stampare lo stacktrace.

Per accorgersi della fine di un `DataInputStream` posso usare l'eccezione `EOFException`. Le eccezioni possono essere usate per implementare la logica della nostra applicazione (non considerandole un errore), se questo è l'expected behaviour del programma.

Per serializzare un oggetto serve in "permesso". Bisogna marcare gli oggetti serializzabili con `Serializable`.

Cos'è _SerialVersionID_? aiuta a tenere traccia della versione di una classe. È utile se si lavora su più versioni contemporaneamente.

Gli array in Java sono serializzabili.