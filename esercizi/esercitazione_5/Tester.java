import javax.swing.*;

public class Tester {
  private static final int WIDTH = 1000;
  private static final int HEIGHT = 1000;

  public Tester() {
    var frame = new JFrame("Animated Man");
    var manPanel = new RiggedPanel(
      new Man(WIDTH, HEIGHT),
      new WarmUpAnimation()
    );

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(WIDTH, HEIGHT);
    frame.setLocationRelativeTo(null);
    frame.add(manPanel);
    frame.setVisible(true);

    manPanel.animationStart();
  }

  public static void main(String[] args) {
    new Tester();
  }
}