# Testo
## JLabel
Il contenuto della JLabel può essere 
```java
JLabel l = new JLabel("Etichetta");
// aggiunta al pannello
```

Il contenuto della `JLabel` può essere aggiornato a runtime.

```java
frame.pack()  // dimensione della finestra al minimo indispensabile per visualizzare il contenuto
```

# Componenti interattivi
## Programmazione ad eventi
Ad ogni oggetto viene associato un ascoltatore (listener), che implementa l'interfaccia `Listener`. La lista di ascoltatori riceve un segnale quando si verifica un determinato evento per cui sono registrati ed esegue di conseguenza il codice appropriato.

### Classi di eventi
Gli eventi usati da Swing sono ereditati da AWT (`AWTEvent`):
- ActionEvent -> click su un componente, invio su un textfield
- ItemEvent -> tipico delle checkbox
- TextEvent -> quando scrivo in una casella di testo
- ComponentEvent
	- WindowEvent -> chiusura, riduzione ad icona
	- FocusEvent -> focus su un componente
	- ...

### Listener
Gli ascoltatori implementano l'interfaccia `Listener`

## JButton
Quando un pulsante viene premuto, viene generato un evento `ActionEvent`. Gli ascoltatori di questo evento devono implementare l'interfaccia `ActionListener`; può essere un metodo di un oggetto esterno al pannello, oppure il pannello stesso.

L'ascoltatore deve implementare il metodo `void actionPerformed(ActionEvent e)`.

Il binding tra ascoltatore ed evento viene fatta con `button.addActionListener(this)`.

L'ascoltatore può essere integrato nel pannello o nell'oggetto che si deve modificare al verificarsi dell'evento.

Quando ho un singolo acition listener per più oggetti posso fare:
1. `String nome = e.getActionCommand()` e applicare un if sul comando contenuto
2. `Object pulsanteIgnoto = e.getSource()` per ottenere l'oggetto chiamante e discriminare qual'e con un if

Il secondo metodo è pià versatile, perchè l'actioncommand vincola al contenuto specifico del componente, che potrebbe essere diversa in base alla lingua.

# Eventi di finstra
Tutte le operazioni sulla finestra (chiusura, apertura, minimizzazione, ingrandimento) generano un `WindowEvent`. Vengono gestiti da oggetti che implementano `WindowListener`.

L'evento più interessante è `windowClosing()` che di default nasconde la finestra, senza killare il processo. Devo quindi chiamare `System.exit()`; oltre a questo posso aggiungere procedure di finalizzazione come il salvataggio di un file.

Per aggiungere ad un frame un window listener faccio:
```java
frame.addWindowListener(new Terminator());
```

