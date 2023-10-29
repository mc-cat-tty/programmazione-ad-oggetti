# Layout
La disposizione dei componenti in un pannello può avvenire tramite un `layout manager` oppure con valori assoluti, usando i metodi `setBounds()` e `setLocation()`.
Il rischio in questo caso è che, al cambiare della risoluzione o della dimensione del monitor, i componenti vadano a finire in posizioni inaspettate.

`LayoutManager` è un'interfaccia. Di defualt viene usato `FlowLayout`. Per impostarne uno diverso:
```java
setLayout(LayoutManager mgr);  // Layout manager
setLayout(null);  // posizione assoluta
```

Possibili alternative:
- `FlowLayout` componenti tutti in fila e centrati. Si spostano con il ridimensionamento della finestra.
- `GridLayout` il layout è diviso in celle. Ad ogni cella è assegnato un componente. Se ridimensiono la finestra il componente cambia dimensione.
- `BorderLayout` può ospitare un componente per ogni settore (east, west, north, south e center). Il componente si ridimensiona se la finstra cambia dimensione. Posso aggirare questo problema usando layout annidati.
- `GridBagLayout` estende il precedente permettendo componenti a cavallo di più celle

