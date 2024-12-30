package Chapter10;

public class CommissionCompensationModel implements CompensationModel{
    double grossSales;
    double commission;

    public CommissionCompensationModel(double grossSales, double commission) {
        this.grossSales = grossSales;
        this.commission = commission;
    }

    @Override
    public double earnings() {
        return grossSales*commission;
    }

    @Override
    public double getSales() {
        return grossSales;
    }
}
