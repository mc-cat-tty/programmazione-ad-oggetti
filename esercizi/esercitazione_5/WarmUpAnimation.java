public class WarmUpAnimation implements Animator{
  private int frameCount = 0;
  private boolean up = true;

  @Override
  public boolean animationRun(Rig rig) {
    frameCount++;
    try { Thread.sleep(10); } catch (Exception e) {}

    if (
      up &&
      !rig.moveLeftArm(3) &
      !rig.moveRightArm(3) &
      !rig.moveLeftLeg(1) &
      !rig.moveRightLeg(1) &
      !rig.moveY(2)
    ) {
      up = false;
    }

    if (
      !up &&
      !rig.moveLeftArm(-3) &
      !rig.moveRightArm(-3) &
      !rig.moveLeftLeg(-1) &
      !rig.moveRightLeg(-1) &
      !rig.moveY(-4)
    ) {
      up = true;
    }

    return true;
  }
}
