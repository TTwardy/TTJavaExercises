package Chapter10;

public class BasePlusCommissionCompensationModel implements CompensationModel{
    double grossSales;
    double commission;
    double baseSalary;

    public BasePlusCommissionCompensationModel(double grossSales, double commission, double baseSalary) {
        this.grossSales = grossSales;
        this.commission = commission;
        this.baseSalary = baseSalary;
    }

    @Override
    public double earnings() {
        return baseSalary+grossSales*commission;
    }

    @Override
    public double getSales() {
        return grossSales;
    }
}
