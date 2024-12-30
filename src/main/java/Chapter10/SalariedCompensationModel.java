package Chapter10;

public class SalariedCompensationModel implements CompensationModel{
    double weeklySalary;

    public SalariedCompensationModel(double weeklySalary){
        this.weeklySalary=weeklySalary;
    }

    @Override
    public double earnings() {
        return weeklySalary;
    }

    @Override
    public double getSales() {
        return 0;
    }
}
