package Synchronized;

/**
 * This demo is meant to show the behavior of not synchronized access \
 * to shared classes and variables, hence a so-called race condition.
 */
public class MainSync {
  public static void main(String[] args) {
    var sharedAccount = new BankAccountSync(100);

    var t1 = new Thread(
      new Runnable() {
        public void run() {
          System.out.println(
            "T1: " + sharedAccount.tryWithdraw(90)
          );
        }
      }
    );

    var t2 = new Thread(
      new Runnable() {
        public void run() {
          System.out.println(
            "T2: " + sharedAccount.tryWithdraw(50)
          );
        }
      }
    );

    t1.start();
    t2.start();

    try {
      t1.join();
      t2.join();
    }
    catch (InterruptedException e) {}
    
    System.out.println("Remaining amount: " + sharedAccount.getAmount());
  }
}