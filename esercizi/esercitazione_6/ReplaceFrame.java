import java.awt.*;
import javax.swing.*;

public class ReplaceFrame extends JFrame {
  public ReplaceFrame(String windowName) {
    super(windowName);
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    setSize(1000, 500);
    setLocationRelativeTo(null);
    
    var contextPanel = new ReplacePanel();
    add(contextPanel);

    pack();
    setVisible(true);
  }

  public void paint(Graphics g) {
    super.paint(g);
  }
}
