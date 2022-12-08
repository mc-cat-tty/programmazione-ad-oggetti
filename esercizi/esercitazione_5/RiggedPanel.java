import java.awt.*;
import javax.swing.*;

public class RiggedPanel extends JPanel {
  Thread animationThread;

  public <T extends JPanel & Rig> RiggedPanel(T rig, Animator animator) {
    super();
    
    setLayout(
      new BorderLayout()
      );

    add(
      rig,
      BorderLayout.CENTER
    );

    animationThread = new Thread(
      new Runnable() {
        @Override
        public void run() {
          while (
            !Thread.currentThread().isInterrupted() &&
            animator.animationRun(rig)
          );
        }
      }
    );
  }

  public void animationStart() {
    animationThread.start();
  }

  public void animationStop() {
    animationThread.interrupt();
  }
}
