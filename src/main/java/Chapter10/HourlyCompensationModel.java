package Chapter10;

public class HourlyCompensationModel implements CompensationModel{
    double wage;
    double hours;

    public HourlyCompensationModel(double wage, double hours){
        this.hours = hours;
        this.wage = wage;
    }
    @Override
    public double earnings() {
        if (getHours() <= 40) { // no overtime
            return getWage() * getHours();
        }
        else {
            return 40 * getWage() + (getHours() - 40) * getWage() * 1.5;
        }
    }

    @Override
    public double getSales() {
        return 0;
    }

    public double getWage() {return wage;}
    public double getHours() {return hours;}
}
