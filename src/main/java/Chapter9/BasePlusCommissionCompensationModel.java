package Chapter9;

public class BasePlusCommissionCompensationModel extends CompensationModel{

    double baseSalary;

    public BasePlusCommissionCompensationModel(double grossSales, double commissionRate, double baseSalary){
        super(grossSales, commissionRate);
        this.baseSalary=baseSalary;
    }

    protected double earnings (){
        return baseSalary+grossSales*commissionRate;
    }
}
