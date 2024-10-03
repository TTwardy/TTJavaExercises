package Chapter9;

public class CommissionCompensationModel extends CompensationModel {


    public CommissionCompensationModel(double grossSales, double commissionRate){
        super(grossSales, commissionRate);
    }

    protected double earnings (){
        return grossSales*commissionRate;
    }
}
