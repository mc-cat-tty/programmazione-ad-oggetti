## Esercizio
Disegnare un omino all'interno di una finestra con Swing. Provare poi ad animare l'omino.

### Consigli
Il `JPanel` è un oggetto di classe `Container`, ovvero un contenitore di altri elementi grafici; non ha vita da solo, deve essere contenuto in un `JFrame`.

Istanziare un frame non vuol dire renderlo visibile. Per rendere un `JFrame` il main frame della mia applicazione, basta rendere l'operazione di chiusura un exit:
```java
JFrame frame = new JFrame("Title");
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setLocationRelativeTo(null);  // Centra il frame
// Operazioni varie sul frame
frame.setVisbible(true);  // Sempre ultima
```

Per disegnare l'omino mi serve un `JPanel` personalizzato con tutti gli elementi grafici necessari, da inserire in un `JFrame`.

Per disegnare su un `JPanel` uso il metodo di callback `paintComponent(Graphics g)`, che non devo mai chiamare a mano, perchè il refresh è compito del sistema operativo.

L'origine di un componente tipo l'ovale, si riferisce alla posizione dell'angolo in alto a sinistra del rettangolo che lo circoscrive.

Dentro a `main()` chiama `new Main()` ovvero il costruttore della classe, dove si trova il codice per costruire l'interfaccia.

Per avere più metodi a disposizione su `Graphics` puoi fare `Graphics2D g`

## Caricamento da URI
Vedi: `ImageIO.read(new URL("..."))` o `ImageIO.read(new File("..."))` che potrebbero sollevare una `IOException`.

## Animazioni
Mi serve un thread parallelo che aggiorni la posizione dell'elemento che si vuole muovere, passando questo valore al thread principale. 

Si possono usare `Timer` (contatore con ping periodico) e `TimerTask` (logica da eseguire ad ogni ping):
```java
Animatore animatore = new Animatore(this);
Timer timer = new Timer();
timer.scheduleAtFixedRate(animatore, waitBeforeRun, runEachNSeconds);
```

Il task è implementato come:
```java
public class Animatore extends TimerTask {
	PannelloOmino pannelloOmino;
	// constructor
	@Override
	void run() {
		pannelloOmino.setVariables(...);
		pannelloOmino.anima(); // esegue this.repaint()
	}
}
```

