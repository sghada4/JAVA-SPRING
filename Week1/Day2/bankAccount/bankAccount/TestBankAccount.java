public class TestBankAccount{
    public static void main(String[] args){
        BankAccount account = new BankAccount(1800, 600.5);
        System.out.println("Number of accounts: "+BankAccount.numberOfAccounts);
        System.out.println("Total amount of money: "+BankAccount.totalAmountOfMoney);
        account.depositMoney(500);
        account.withdrawMoney(200.5);
        account.display();
    }
}