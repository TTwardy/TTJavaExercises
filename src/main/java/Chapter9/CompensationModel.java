package Chapter9;

public class CompensationModel {
    double grossSales;
    double commissionRate;

    public  CompensationModel(double grossSales, double commissionRate){
        this.grossSales=grossSales;
        this.commissionRate=commissionRate;
    }

    protected double earnings (){
        return grossSales*commissionRate;
    }
}
