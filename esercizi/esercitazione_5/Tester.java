import javax.swing.*;

public class Tester {
  public Tester() {
    var frame = new JFrame("Animated Man");
    var manPanel = new ManPanel();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null);
    frame.add(manPanel);
    frame.pack();
    frame.setVisible(true);

    // var animationThread = new Thread(
    //   new Runnable() {
    //     public void run() {

    //     }
    //   }
    // );
    // animationThread.start();
  }

  public static void main(String[] args) {
    new Tester();
  }
}