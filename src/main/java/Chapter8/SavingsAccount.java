package Chapter8;

public class SavingsAccount {

    private static double annualInterestRate;
    double savingsBalance;
    String name;
    String [] months = {"January","February", "March,", "April", "May", "June", "July", "August", "September", "October", "November", "December"};

    public  SavingsAccount(double savingsBalance, String name){
        this.savingsBalance = savingsBalance;
        this.name=name;
    }
    public void calculateMonthlyInterest(){
        System.out.printf("Account of %s\n", name);
        for (String month: months){
            savingsBalance += savingsBalance*annualInterestRate/12;
            System.out.printf("Monthly interest rate for %s = %,.2f\nTotal Balance = %.02f\n", month, savingsBalance*annualInterestRate/12, savingsBalance);
        }
        System.out.print("\n");
    }
    public static void modifyInterestRate(double rate){
        annualInterestRate = rate;
    }
}
