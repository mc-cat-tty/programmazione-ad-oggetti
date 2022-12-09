import javax.swing.*;
import java.util.*;

public class ContactsWindow extends JFrame {
  public ContactsWindow(String name, Collection<Contact> contacts) {
    super(name);

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    add(
      new ContactsPanel(
        contacts
      )
    );
    pack();
    setLocationRelativeTo(null);
    setVisible(true);
  }
}
