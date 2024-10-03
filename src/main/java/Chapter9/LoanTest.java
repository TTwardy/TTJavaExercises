package Chapter9;

public class LoanTest {
    public static void main(String[] args) {
        VehicleLoan loan = new VehicleLoan(1000,12,0.10);
        System.out.println(loan.calculateInterestRate());
    }
}
