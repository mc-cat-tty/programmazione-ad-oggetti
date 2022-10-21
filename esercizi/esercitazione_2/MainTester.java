package esercizi.esercitazione_2;

public class MainTester {
  public static void main(String[] args) {
    ContoCorrente cc = new ContoCorrente(1234, -50);

    cc.printTransactionHistory();
    System.out.println("Balance: " + cc.getCurrentBalance());

    cc.withdrawal(50);
    cc.withdrawal(100);
    cc.withdrawal(50);
    cc.deposit(200);
    cc.deposit(500);

    cc.printTransactionHistory();
    System.out.println("Balance: " + cc.getCurrentBalance());
  }
}