public class BankAccount {

  private double checkingBalance;
  private double savingsBalance;
  public static int numberOfAccounts = 0;
  public static double totalAmountOfMoney = 0;

  public BankAccount(double checkingBalance, double savingsBalance) {
    this.checkingBalance = checkingBalance;
    this.savingsBalance = savingsBalance;
    numberOfAccounts++;
    totalAmountOfMoney = this.checkingBalance + this.savingsBalance;
  }

  public double getCheckingBalance() {
    return this.checkingBalance;
  }

  public void setCheckingBalance(double checkingBalance) {
    this.checkingBalance = checkingBalance;
  }

  public double getSavingsBalance() {
    return this.savingsBalance;
  }

  public void setSavingsBalance(double savingsBalance) {
    this.savingsBalance = savingsBalance;
  }

  public void depositMoney(double money) {
    setSavingsBalance(money);
    totalAmountOfMoney = this.getCheckingBalance() + this.getSavingsBalance();
  }

  public boolean withdrawMoney(double money){
    double testBalanceMoney = this.checkingBalance - money;
    if(testBalanceMoney>0){
        setCheckingBalance(testBalanceMoney);
        return true;
    }else{
        setCheckingBalance(this.checkingBalance);
        return false;
    }
  }

  public void display(){
    System.out.println("Checking Balance= "+this.checkingBalance);
    System.out.println("Savings Balance= "+this.savingsBalance);
  }
}
