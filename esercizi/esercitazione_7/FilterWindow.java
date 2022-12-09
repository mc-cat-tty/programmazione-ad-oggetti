import javax.swing.*;


public class FilterWindow extends JFrame {
  public FilterWindow(String name) {
    super(name);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    add(
      new FilterPanel()
    );

    pack();
    setLocationRelativeTo(null);
    setVisible(true);
  }
}
