import javax.naming.event.EventDirContext;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.*;
import java.util.EventObject;

public class ReplacePanel extends JPanel
  implements ActionListener {
  static final int TEXT_AREA_ROWS = 2;
  static final int TEXT_AREA_COLS = 50;
  static final int TEXT_FIELD_COLS = 4;

  JButton replaceButton = new JButton("Sostituisci");
  JTextArea inputTextArea = new JTextArea(TEXT_AREA_ROWS, TEXT_AREA_COLS);
  JTextArea outputTextArea = new JTextArea(TEXT_AREA_ROWS, TEXT_AREA_COLS);
  JLabel oldCharLabel = new JLabel("Vecchio Carattere: ");
  JTextField oldCharField = new JTextField(TEXT_FIELD_COLS);
  JLabel newCharLabel = new JLabel("Nuovo carattere: ");
  JTextField newCharField = new JTextField(TEXT_FIELD_COLS); 

  ReplacePanel() {
    super();

    outputTextArea.setEditable(false);
    outputTextArea.setBackground(Color.LIGHT_GRAY);
    replaceButton.addActionListener(this);

    addComponents();
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    eventDispatcher((Component) e.getSource());
  }

  private void eventDispatcher(Component comp) {
    if (comp == replaceButton) {
      replaceCallback();
    }
    // not so KISS
  }

  private void replaceCallback() {
    final String inputText = inputTextArea.getText();
    if (inputText.length() <= 0) {
      return;
    }

    outputTextArea.setText(
      inputText
        .replace(
          oldCharField.getText(),
          newCharField.getText()
        )
    );
  }

  private void addComponents() {
    setLayout(new BorderLayout());

    add(oldCharLabel);
    add(newCharLabel);

    var panelNorth = new JPanel();
    panelNorth.add(inputTextArea);
    add(panelNorth, BorderLayout.NORTH);

    var panelCenter = new JPanel();
    panelCenter.add(oldCharLabel);
    panelCenter.add(oldCharField);
    panelCenter.add(newCharLabel);
    panelCenter.add(newCharField);
    add(panelCenter, BorderLayout.CENTER);

    var panelSouth = new JPanel();
    var layoutSouth = new BorderLayout();
    layoutSouth.setVgap(5);
    panelSouth.setLayout(layoutSouth);
    panelSouth.add(outputTextArea, BorderLayout.NORTH);
    panelSouth.add(replaceButton, BorderLayout.SOUTH);
    panelSouth.setBorder(new EmptyBorder(10, 10, 10, 10));
    add(panelSouth, BorderLayout.SOUTH);
  }
}