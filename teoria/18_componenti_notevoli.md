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

## JTextField
Il campo di testo è parte di un oggetto Document.
Ogni volta che il testo nel JTextField viene modificato, si scatena un evento `DocumentEvent`. Quando si preme Invio viene generato un `ActionEvent`.
Il testo viene bloccato fino alla fine dell'event listener. Quindi al suo interno non posso modificare il contenuto.

```java
textField.setEditable(false);  // rende il campo di testo non modificabile
String txt = textField.getText();  // ottengo testo
textField.setText(String s);  // setto il testo
```

Possibili soluzioni per creare una gui con 2 campi testo, uno in sola lettura e l'altro in scrittura:
- 2 campi e un pulsante, sul quale viene registrato l'actionListener
- 2 campi con un actionListener sul campo in scrittura
- 2 campi con un documentListener

### Interfaccia DocumentListener
```java
textField.getDocument().addDocumentListener(this);
```

Metodi dell'interfaccia `DocumentListener`:
```java
void insertUpdate(DocumentEvent e);
void changeUpdate(DocumentEvent e);
void removeUpdate(DocumentEvent e);
```

Devo implementare tutti e 3 i metodi, ma lascio il corpo vuoto in quelli di cui non ho bisogno.

## JCheckBox
Posso interrogare ogni checkbox sul suo stato con `isSelected()`. Oltre al solito `ActionEvent` genera anche un `ItemEvent`, che solitamente si preferisce perchè più specifico.

L'oggetto ascolatore deve implementare `ItemListener`:
```java
void itemStateChanged(ItemEvent e);
```

All'interno del quale possiamo fare: `Object source = e.getItemSelectable()`

## JRadioButton
Forniscono opzioni in mutua esclusione. Quando un radio button viene selezionato gli altri sono deselezionati. Di conseguenza, ogni volta che si seleziona un radio button, si generano 3 eventi:
- ItemEvent per la casella selezionata
- ItemEvent per la casella deselezionata
- ActionEvent dalla casella selezionata -> conviene gestire questo al posto degli ItemEvent (perchè ne arrivano 2)

## JList
Lista di elementi selezionabili.

Interfaccia: `ListSelectionListener`,che definisce `void valueChanged(ListSelectionEvent e)`.

```java
Object[] scelte = list.getSelectedValues();
```

Con Shift e Ctrl si possono selezionare più valori.
Attenzione: non è una struttura dati, ma un elemento grafico

## JScrollPane
Decoratore che si usa in congiunzione ad una JList
```java
var list = new JList(voci);
var pane = new JScrollPane(list);  // due contenitori annidati
...
```

# Eventi di finestra
Tutte le operazioni sulla finestra (chiusura, apertura, minimizzazione, ingrandimento) generano un `WindowEvent`. Vengono gestiti da oggetti che implementano `WindowListener`.

L'evento più interessante è `windowClosing()` che di default nasconde la finestra, senza killare il processo. Devo quindi chiamare `System.exit()`; oltre a questo posso aggiungere procedure di finalizzazione come il salvataggio di un file.

Per aggiungere ad un frame un window listener faccio:
```java
frame.addWindowListener(new Terminator());
```

