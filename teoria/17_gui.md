# Interfacce Grafiche
Package del JDK:
- AWT - `java.awt`
- Swing - `javax.swing` (*x* sta per extension)

AWT - Abstract Windows Toolkit. Usa codice nativo per visualizzare i componenti: sistema peer-to-peer per visualizzare i componenti grafici (ogni J components è mappato in un componente del SO). 

**AWT vs Swing**
| Caratteristica | AWT                               | Swing                                  |
| -------------- | --------------------------------- | -------------------------------------- |
| Velocità       | Veloce                            | Più lento perchè non usa codice nativo |
| Portabilità    | Supportato dai browser più vecchi | Migliore portabilità                   |
| Look&feel      | Simile a quello del SO            | Configurabile                          |

Java FX è stata rimossa dal JDK

## Swing
Swing mette a disposizione più *widget* - window gadget - di due tipi diversi:
- **pesanti** hanno una corrispondenza 1:1 con i widget del SO
- **leggeri** disegnati via software da Swing

Adotta una filosofia ad oggetti.

Vedi: JFC - Java Foundation Classes
```bash
java -jar SwingSet2.jar
```

Un componente della GUI ha il focus se è quello pronto a ricevere comandi dalla tastiera.

## Tipi di componenti
- **Radio button** una scelta tra molteplici possibili
- **Checkbox** zero o più scelte tra quelle possibili
- **Color chooser**
- **File chooser**
- **HTML demo panel**
- **Dialog**
	- Info
	- Warning
- **Slider**
- **Split pane**
- **Tabbed pane**
- **Table**
- **Tooltip**

## Programmazione ad eventi
Ogni evento viene rilevato e gestito da un ascoltatore, ovvero un oggetto bindato all'evento. 

## Architettura di una GUI
Solitamente è costituita da 3 livelli, non sempre distinti, come nel caso di Windows:
1. Window manager: lv più alto. Determina il look and feel.
2. Server grafico: disegna forme utilizzando le primitive del SO.
3. Sistema operativo: lv più basso. Mette a disposizione primitive di basso livello, per disegnare un punto di diversi colori.

## Sistema di coordinate
Il sistema di riferimento adottato è speculare alle coordinate normalmente adottate rispetto all'asse x. Una funzione che cresce va verso il basso.

# Componenti
## Gerarchia
![[swing_hierarchy.png]]

## JFrame
Implementa la finestra di un'applicazione. Ha un bordo. In alto si trova la barra con i pulsanti per interagire con la finestra. Lo stile del JFrame dipende dal WM.

```java
var jf = new JFrame("Title");
jf.setVisible(true);
```
Così facendo viene creata una finestra di dimensione minima (contenente i 3 pulsanti della barra). 
Chiudere una finestra = nascondere il frame != terminare l'applicazione

Metodi:
- `setBounds(distX, distY, dimX, dimY)` dove le dimensioni non considerano la status bar
- `setDefaultCloseOperation(int operation)`
	- DO_NOTHING_ON_CLOSE
	- HIDE_ON_CLOSE
	- EXIT_ON_CLOSE: termina l'applicazione
	- DISPOSE_ON_CLOSE: nasconde e distrugge il frame

Si può definire in frame custom estendendo `JFrame`. Non è necessario specificare su quale oggetto chiamare i metodi, perchè vengono chiamati su quello corrente.

## JPanel
```java
var panel = new JPanel()
frame.add(panel);
```

Il pannello consente di inserire componenti grafici già pronti o di disegnare figure geometriche elementari.

