package Chapter9;

public class HourlyEmployee extends Employee{
    double hours;
    double wage;

    public HourlyEmployee(String firstName, String lastName, String socialSecurityNumber, double hours, double wage){
        super(firstName, lastName, socialSecurityNumber);
        if (wage<0){
            throw new IllegalArgumentException("Wage cannot be negative");
        }
        if (hours<0 || hours>168){
            throw new IllegalArgumentException("Wrong hours");
        }
        this.hours=hours;
        this.wage=wage;
    }

    public double getHours(){return hours;}
    public double getWage(){return wage;}

    public void setHours(double hours) {
        if (hours<0 || hours>168){
            throw new IllegalArgumentException("Wrong hours");
        }
        this.hours = hours;
    }
    public void setWage(double wage) {
        if (wage<0){
            throw new IllegalArgumentException("Wage cannot be negative");
        }
        this.wage = wage;
    }
}
