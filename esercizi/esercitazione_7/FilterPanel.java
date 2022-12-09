import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.InternalFrameEvent;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.stream.Stream;

public class FilterPanel extends JPanel {
  private static final int PADDING = 10;
  private JTextField inputField = new JTextField("Demo123", 20);
  private JTextField outputField = new JTextField(20);
  private JButton selectButton = new JButton("Seleziona");
  private JCheckBox charBox = new JCheckBox("Lettere", true);
  private JCheckBox numBox = new JCheckBox("Numeri", true);
  private boolean filterChar = true;
  private boolean filterNum = true;
  
  public FilterPanel() {
    super(
      new BorderLayout(PADDING, PADDING)
    );
    setBorder(new EmptyBorder(PADDING, PADDING, PADDING, PADDING));

    composePanel();
    
    selectButton.addActionListener(
      event ->
        outputField.setText(
          inputField
            .getText()
            .chars()
            .filter(
              c ->
                filterNum && Character.isDigit(c) || 
                filterChar && Character.isLetter(c)
            )
            .collect(
              StringBuilder::new,
              StringBuilder::appendCodePoint,
              StringBuilder::append
            )
            .toString()
        )
    );

    charBox.addItemListener(
      event -> {
        filterChar = (event.getStateChange() == ItemEvent.SELECTED);
        
        if (!filterChar && !filterNum) {
          selectButton.setEnabled(false);
          return;
        }

        selectButton.setEnabled(true);
      }
    );

    numBox.addItemListener(
      event -> {
        filterNum = (event.getStateChange() == ItemEvent.SELECTED);

        if (!filterChar && !filterNum) {
          selectButton.setEnabled(false);
          return;
        }

        selectButton.setEnabled(true);
      }
    );
  }

  private void composePanel() {
    add(
      inputField,
      BorderLayout.NORTH
    );

    outputField.setEditable(false);
    outputField.setBackground(Color.LIGHT_GRAY);
    add(
      outputField,
      BorderLayout.CENTER
    );


    var southPanel = new JPanel(new FlowLayout());
    southPanel.add(charBox);
    southPanel.add(numBox);
    southPanel.add(selectButton);

    add(
      southPanel,
      BorderLayout.SOUTH
    );
  }
}
