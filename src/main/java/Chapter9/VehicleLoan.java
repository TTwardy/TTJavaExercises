package Chapter9;

public class VehicleLoan extends Loan {
    protected double rate;
    public VehicleLoan(int amount, int tenure, double rate) {
        super(amount, tenure);
        this.rate = rate;

    }

    protected double calculateInterestRate (){
        return amount*(rate+1)/tenure;
    }
}
