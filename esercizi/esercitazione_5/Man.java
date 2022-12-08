import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.math.*;

public class Man extends JPanel implements Rig {
  private final static double MAX_ARMS_ANGLE = Math.PI * 3/4;
  private final static double MAX_LEGS_ANGLE = Math.PI / 4;
  private final static double MIN_ARMS_ANGLE = Math.PI / 18;
  private final static double MIN_LEGS_ANGLE = Math.PI / 18;
  private int paddingTop;
  private int width;
  private int height;
  private int headRadius;
  private int neckLength;
  private int shouldersWidth;
  private int bodyLength;
  private int armLength;
  private int handLength;
  private int legLength;
  private double armRightAngleRad;
  private double armLeftAngleRad;
  private double legRightAngleRad;
  private double legLeftAngleRad;

  public Man(int width, int height) {
    super();
    this.width = width;
    this.height = height;

    int unit = width/20;
    this.paddingTop = width/10;
    this.headRadius = unit;
    this.neckLength = unit;
    this.shouldersWidth = unit*3;
    this.bodyLength = unit*4;
    this.armLength = unit*3;
    this.handLength = unit;
    this.legLength = unit*5;

    
    armRightAngleRad = degToRad(30);
    armLeftAngleRad = degToRad(30);
    legRightAngleRad = degToRad(20);
    legLeftAngleRad = degToRad(20);
  }

  @Override
  public synchronized void paint(Graphics g) {
    var g2 = (Graphics2D) g;
    g2.clearRect(0, 0, width, height);
    g2.setStroke(new BasicStroke(5));

    // head
    int centerX = width/2;
    g2.drawOval(
      centerX - (headRadius*2 - width/100)/2,
      paddingTop,
      headRadius*2 - width/100,
      headRadius*2
    );

    // neck
    int neckY1 = paddingTop + 2*headRadius;
    int neckY2 = neckY1 + neckLength;
    g2.drawLine(
      centerX,
      neckY1,
      centerX,
      neckY2
    );

    // shoulders
    var q = new QuadCurve2D.Float();
    int shouldersX1 = centerX - shouldersWidth/2;
    int shouldersX2 = centerX + shouldersWidth/2;
    int shouldersY = neckY2 + (neckY2 - neckY1) / 2;
    q.setCurve(
      shouldersX1,
      shouldersY,
      centerX,
      (neckY1 + neckY2) / 2,
      shouldersX2,
      shouldersY
    );
    g2.draw(q);

    // arm right
    g2.drawLine(
      shouldersX2,
      shouldersY,
      shouldersX2 + (int) (Math.sin(armRightAngleRad) * (double) armLength),
      shouldersY + (int) (Math.cos(armRightAngleRad) * (double) armLength)
    );

    // arm left
    g2.drawLine(
      shouldersX1,
      shouldersY,
      shouldersX1 - (int) (Math.sin(armLeftAngleRad) * (double) armLength),
      shouldersY + (int) (Math.cos(armLeftAngleRad) * (double) armLength)
    );

    // body
    int bodyY1 = neckY2;
    int bodyY2 = bodyY1 + bodyLength;
    g2.drawLine(
      centerX,
      bodyY1,
      centerX,
      bodyY2
    );

    // pelvis
    int pelvisY1 = bodyY2;
    int pelvisY2 = pelvisY1 + headRadius;
    int pelvisWidth = headRadius * 2;
    g2.drawOval(
      centerX - headRadius,
      pelvisY1,
      pelvisWidth,
      headRadius
    );

    // leg right
    int legRightX1 = centerX + pelvisWidth/2;
    int legY1 = pelvisY2;
    g2.drawLine(
      legRightX1,
      legY1,
      legRightX1 + (int) (Math.sin(legRightAngleRad) * (double) legLength),
      legY1 + (int) (Math.cos(legRightAngleRad) * (double) legLength)
    );

    //leg left
    int legLeftX1 = centerX - pelvisWidth/2;
    g2.drawLine(
      legLeftX1,
      legY1,
      legLeftX1 - (int) (Math.sin(legLeftAngleRad) * (double) legLength),
      legY1 + (int) (Math.cos(legLeftAngleRad) * (double) legLength)
    );
  }

  private double degToRad(int angleDeg) {
    double k = Math.PI / 180;
    return k * (double) angleDeg;
  }

  @Override
  public synchronized boolean moveLeftArm(int angleDeg) {
    armLeftAngleRad += degToRad(angleDeg);
    
    if (armLeftAngleRad >= MAX_ARMS_ANGLE || armLeftAngleRad <= MIN_ARMS_ANGLE) {
      armLeftAngleRad -= degToRad(angleDeg);
      return false;
    }
    
    this.repaint();
    return true;
  }

  @Override
  public synchronized boolean moveLeftLeg(int angleDeg) {
    legLeftAngleRad += degToRad(angleDeg);
    
    if (legLeftAngleRad >= MAX_LEGS_ANGLE || legLeftAngleRad <= MIN_LEGS_ANGLE) {
      legLeftAngleRad -= degToRad(angleDeg);
      return false;
    }
    
    this.repaint();
    return true;
  }

  @Override
  public synchronized boolean moveRightArm(int angleDeg) {
    armRightAngleRad += degToRad(angleDeg);

    if (armRightAngleRad >= MAX_ARMS_ANGLE || armRightAngleRad <= MIN_ARMS_ANGLE) {
      armRightAngleRad -= degToRad(angleDeg);
      return false;
    }
    
    this.repaint();
    return true;
  }

  @Override
  public synchronized boolean moveRightLeg(int angleDeg) {
    legRightAngleRad += degToRad(angleDeg);
    
    if (legRightAngleRad >= MAX_LEGS_ANGLE || legRightAngleRad <= MIN_LEGS_ANGLE) {
      legRightAngleRad -= degToRad(angleDeg);
      return false;
    }
    
    this.repaint();
    return true;
  }
  
  @Override
  public synchronized boolean moveY(int height) {
    paddingTop += height;

    final int rigHeight =
      headRadius*2 +
      neckLength +
      bodyLength +
      headRadius +
      legLength;

    if (paddingTop <= width/50 || paddingTop >= (this.height - rigHeight)) {
      paddingTop -= height;
      return false;
    }

    this.repaint();
    return true;
  }
}
