package esercizi.esercitazione_2;

import java.util.Arrays;

public class ContoCorrente {
  private static final int TRANSACTION_HISTORY_DEF_DIM = 2;
  private int accountId;
  private int currentBalance;
  private int[] transactionHistory;
  private int transactitonCounter;

  ContoCorrente(int accountId, int currentBalance) {
    this.accountId = accountId;
    this.currentBalance = currentBalance;
    this.transactionHistory = new int[TRANSACTION_HISTORY_DEF_DIM];
  }

  public int getAccountId() {
    return accountId;
  }

  public int getCurrentBalance() {
    return currentBalance;
  }

  public int getTransactionCounter() {
    return transactitonCounter;
  }

  public void printTransactionHistory() {
    String prefix;

    System.out.println("Transactions: ");
    for (int i=0; i<transactitonCounter; i++) {
      prefix = "";
      if (transactionHistory[i] > 0) {
        prefix = "+";
      }
      System.out.println(prefix+transactionHistory[i]);
    }
  }

  private boolean tryAddToTransactionHistory(int val) {
    if (transactitonCounter >= transactionHistory.length) {
      return false;
    }

    transactionHistory[transactitonCounter++] = val;
    return true;
  }

  private void expandTransactionHistory() {
    transactionHistory = Arrays.copyOf(transactionHistory, transactionHistory.length*2);
  }

  private void addToTransactionHistory(int val) {
    if (!tryAddToTransactionHistory(val)) {
      expandTransactionHistory();
      tryAddToTransactionHistory(val);
    }
  }

  private void transaction(int val) {
    currentBalance += val;
    addToTransactionHistory(val);
  }

  public boolean withdrawal(int val) {
    if (val <= 0) {
      return false;
    }

    transaction(-val);
    return true;
  }

  public boolean deposit(int val) {
    if (val <= 0) {
      return false;
    }

    transaction(val);
    return true;
  }
}
