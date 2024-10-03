package Chapter9;

public class BasePlusCommissionEmployee {
    private double baseSalary; // base salary per week
    CommissionEmployee employee;

    // six-argument constructor
    public BasePlusCommissionEmployee(String firstName, String lastName,
                                      String socialSecurityNumber, double grossSales,
                                      double commissionRate, double baseSalary) {

        this.employee = new CommissionEmployee(firstName, lastName, socialSecurityNumber,
                grossSales, commissionRate);

        // if baseSalary is invalid throw exception
        if (baseSalary < 0.0) {
            throw new IllegalArgumentException("Base salary must be >= 0.0");
        }

        this.baseSalary = baseSalary;
    }

    // set base salary
    public void setBaseSalary(double baseSalary) {
        if (baseSalary < 0.0) {
            throw new IllegalArgumentException("Base salary must be >= 0.0");
        }

        this.baseSalary = baseSalary;
    }

    // return base salary
    public double getBaseSalary() {return baseSalary;}

    // calculate earnings

    public double earnings() {return getBaseSalary() + employee.earnings();}

    // return String representation of BasePlusCommissionEmployee
    public String toString() {
        return String.format("%s %s%n%s: %.2f", "base-salaried",
                employee.toString(), "base salary", getBaseSalary());
    }
}
