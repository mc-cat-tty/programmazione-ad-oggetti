import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ContactsPanel extends JPanel {
  private static final int PADDING = 10;
  private Collection<Contact> contacts;
  private JTable table;
  private TableModel model;
  private JTextField searchInputArea = new JTextField(20);
  private JButton searchButton = new JButton("Cerca");
  private JTextField searchResultArea = new JTextField(30);
  
  public ContactsPanel(Collection<Contact> contacts) {
    super(
      new BorderLayout(PADDING, PADDING)
    );

    setBorder(
      new EmptyBorder(
        PADDING,
        PADDING,
        PADDING,
        PADDING
      )
    );

    this.contacts = contacts;

    this.model = new AbstractTableModel() {
      final String[] NAMES = new String[] {
        "Nome",
        "Cognome",
        "Indirizzo",
        "Numero",
      };

      @Override
      public int getColumnCount() {
        return Contact.class.getDeclaredFields().length;
      }

      @Override
      public int getRowCount() {
        return contacts.size();
      }

      @Override
      public String getColumnName(int col) {
        return NAMES[col];
      }

      @Override
      public void setValueAt(Object value, int row, int col) { }

      @Override
      public Object getValueAt(int row, int col) {
        Contact c = (Contact) contacts.toArray()[row];

        switch (col) {
          case 0: return c.getName();
          case 1: return c.getSurname();
          case 2: return c.getStreet();
          case 3: return c.getPhoneNumber();
          default: return "";
        }
      }

      @Override
      public boolean isCellEditable(int row, int col) {
        return false;
      }
    };

    composePanel();

    searchButton.addActionListener(
      event -> searchResultArea.setText(
        contacts
          .stream()
          .map(Contact::toString)
          .filter(
            contact -> contact
              .toLowerCase()
              .contains(
                searchInputArea
                  .getText()
                  .toLowerCase()
              )
          )
          .collect(Collectors.toList())
          .get(0)
          .toString()
      )
    );
  }

  private void composePanel() {
    this.table = new JTable(
      this.model
    );
    

    var northPanel = new JPanel(
      new BorderLayout()
    );

    northPanel.add(
      this.table,
      BorderLayout.CENTER
    );

    northPanel.add(
      this.table.getTableHeader(),
      BorderLayout.NORTH
    );


    add(
      northPanel,
      BorderLayout.NORTH
    );


    var centerPanel = new JPanel(
      new FlowLayout()
    );
    
    centerPanel.add(
      searchInputArea
    );
    
    centerPanel.add(
      searchButton
    );

    add(
      centerPanel,
      BorderLayout.CENTER
    );

    searchResultArea.setEditable(false);
    searchResultArea.setBackground(Color.LIGHT_GRAY);
    add(
      searchResultArea,
      BorderLayout.SOUTH
    );
  }
}
