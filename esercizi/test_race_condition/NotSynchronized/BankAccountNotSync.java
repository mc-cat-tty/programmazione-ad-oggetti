public class BankAccountNotSync {
  private static long lastId = 0;
  protected long id;
  protected int amount;

  public BankAccountNotSync(int amount) {
    setAmount(amount);
    this.id = ++lastId;
  }
  
  public int getAmount() {
    return amount;
  }
  
  private void setAmount(int amount) {
    if (amount < 0) {
      return;
    }

    this.amount = amount;
  }

  public long getId() {
    return id;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }

    if (obj == null) {
      return false;
    }
  
    if (obj.getClass() != getClass()) {
      return false;
    }

    BankAccountNotSync other = (BankAccountNotSync) obj;
    
    if (other.id != id) {
      return false;
    }

    return true;
  }

  /**
   * Tryes to withdraw an amount of money from a bank account.
   * @param withdrawRequest amount to withdraw. 
   * @return effectively withdrawn amount.
   */
  public int tryWithdraw(int withdrawRequest) {
    if (withdrawRequest < 0) {
      return 0;
    }

    if (withdrawRequest > amount) {
      withdrawRequest = amount;
    }

    for (var i = 0; i < 10000; i++) {}  // long operation

    amount -= withdrawRequest;
    return withdrawRequest;
  }

}
