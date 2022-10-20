# Eccezioni
In C la gestione delle eccezioni avveniva con il ritorno di variabili booleane oppure con la stampa a schermo di un messaggio di errore.
Voglio racchiudere nello stesso oggetto il tipo di eccezione ed, eventualmente, in messaggio associato.

In Java esistono classi per gestire le eccezioni (oggetti + costrutto verifica).
Alla radice di questa gerarchia si trova `Throwable` che ha due sottoclassi:
- `Error`: errori non recuperabili
- `Exception`: anomalie che possono essere recuperate

Le eccezioni sono oggetti con campi e metodi per la gestione degli stessi.
Esempio: eccezione che viene sollevata quando una trasmissione non va a buon fine. Posso codificare all'interno dell'oggetto che rappresenta l'eccezione il numero di byte che sono riuscito a trasmettere.

## Sollevamento eccezioni
Ogni meotod può sollevare una o più eccezioni; la lista di eccezioni che può sollevare sono elencate dopo `throws`:
```java
returnType myMethod(...) throws exceptionType1, exceptionType2 {...}

// All'interno di myMethod posso lanciare
throw new excpetionType1;
```

## Gestione eccezioni
### Catch
Si usa un blocco `try` - `catch`

```java
try {
	// Metodi a rischio
}
catch (exceptionType1 e) {
	// Vengono catturate tutte le eccezioni che siano di tipo exceptionType1 o sue sottoclassi
}
catch (exceptionType2 e) {
	// Posso andare avanti così aggiungendo blocchi catch
}
```

Nei blocchi try-catch vale la **regola di conformità**. Consiglio: non mettere mai le eccezioni più generiche prima di eccezioni più specifiche. Parti dal più specifico verso il più generale.

### Rilancio
Le eccezioni non devono essere per forza gestite, ma possono essere **rilanciate**.
Se l'eccezione si propaga fino al main, il programma termina.

## Eccezioni da non catturare
Le *unchecked exceptions* possono essere gestite, ma non è necessario catturarle.

Queste eccezioni sono tipo le `RuntimeExceptions`. Eg: `IndexOutOfBoundaryException`

