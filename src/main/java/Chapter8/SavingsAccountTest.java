package Chapter8;

public class SavingsAccountTest {
    public static void main (String[] args){
        SavingsAccount saver1 = new SavingsAccount(100000, "John");
        SavingsAccount saver2 = new SavingsAccount(200000, "Kate");
        SavingsAccount.modifyInterestRate(0.04);
        saver1.calculateMonthlyInterest();
        saver2.calculateMonthlyInterest();
        SavingsAccount.modifyInterestRate(0.05);
        saver1.calculateMonthlyInterest();
        saver2.calculateMonthlyInterest();
    }
}
