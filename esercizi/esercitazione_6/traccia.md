# Programmazione ad eventi

Design pattern comune nella programmazione di interfacce grafiche.

Per ogni tipo di evento registro uno o più metodi di callback, che verranno chiamati nel momento più opportuno dal SO.

Posizionamento assoluto -> sconsigliato perchè dipende da dimensione e risoluzione dello schermo

## Layout
Borderlayout e Flowlayouti -> ho 5 settori, che possono accettare layout innestati:
- north
- west
- center
- east
- south

Vedi: layout constraints

```java
frame.add(component, BorderLayout.NORTH);
panel.setLayout(new BorderLayout());  // BorderLayout

panel.setLayout(null);  // Absolute Layout
comp.setBounds(...);  // Sconsigliato
```

## Implmentazione interfacce anonime
```java
pulsante.addActionListener(
	new ActionListener() {  // normalmente non possibile. Qui crea un oggetto che sia conforme all'interfaccia ed anonimo

		@Override
		public void actionPerformed(ActionEvent e) {
			// Callback body
		}

	}
);
```

