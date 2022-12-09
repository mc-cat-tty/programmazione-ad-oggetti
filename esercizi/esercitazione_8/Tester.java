import java.util.*;

public class Tester {
  public Tester() {
    new ContactsWindow(
      "Esercizio Grafica 4",
      new TreeSet<Contact>() {{
        add(new Contact("Mario", "Rossi", "Via Araldi", 111));
        add(new Contact("Francesco", "Mecatti", "Via Campi", 333));
        add(new Contact("Francesco", "Mecatti", "Stub", 000));
        add(new Contact("Stub", "Stub", "Stub", 333));
      }}
    );
  }
  
  public static void main(String[] args) {
    new Tester();
  }
}