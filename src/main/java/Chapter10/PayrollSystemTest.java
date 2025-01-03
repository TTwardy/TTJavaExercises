package Chapter10;

import java.time.LocalDateTime;

public class PayrollSystemTest {
    public static void main(String[] args) {
        // create subclass objects
        SalariedEmployee salariedEmployee =
                new SalariedEmployee("John", "Smith", "111-11-1111", 800.00, 1991, 11, 25);
        HourlyEmployee hourlyEmployee =
                new HourlyEmployee("Karen", "Price", "222-22-2222", 16.75, 40,1977, 4, 5);
        CommissionEmployee commissionEmployee =
                new CommissionEmployee(
                        "Sue", "Jones", "333-33-3333", 10000, .06,1995, 2, 1);
        BasePlusCommissionEmployee basePlusCommissionEmployee =
                new BasePlusCommissionEmployee(
                        "Bob", "Lewis", "444-44-4444", 5000, .04, 300,1999, 11, 25);
        PieceWorker pieceWorker = new PieceWorker("Adam", "Grave", "233-423-555", 1980, 6, 22, 100, 14 );
        System.out.println("Employees processed individually:");

        System.out.printf("%n%s%n%s: $%,.2f%n%n",
                salariedEmployee, "earned", salariedEmployee.getPaymentAmount());
        System.out.printf("%s%n%s: $%,.2f%n%n",
                hourlyEmployee, "earned", hourlyEmployee.getPaymentAmount());
        System.out.printf("%s%n%s: $%,.2f%n%n",
                commissionEmployee, "earned", commissionEmployee.getPaymentAmount());
        System.out.printf("%s%n%s: $%,.2f%n%n",
                basePlusCommissionEmployee,
                "earned", basePlusCommissionEmployee.getPaymentAmount());

        // create four-element Employee array
        Employee[] employees = new Employee[5];

        // initialize array with Employees
        employees[0] = salariedEmployee;
        employees[1] = hourlyEmployee;
        employees[2] = commissionEmployee;
        employees[3] = basePlusCommissionEmployee;
        employees[4] = pieceWorker;

        System.out.printf("Employees processed polymorphically:%n%n");

        // generically process each element in array employees
        for (Employee currentEmployee : employees) {
            System.out.println(currentEmployee); // invokes toString

            // determine whether element is a BasePlusCommissionEmployee
            if (currentEmployee instanceof BasePlusCommissionEmployee) {
                // downcast Employee reference to
                // BasePlusCommissionEmployee reference
                BasePlusCommissionEmployee employee =
                        (BasePlusCommissionEmployee) currentEmployee;

                employee.setBaseSalary(1.10 * employee.getBaseSalary());

                System.out.printf(
                        "new base salary with 10%% increase is: $%,.2f%n",
                        employee.getBaseSalary());
            }

            if (currentEmployee.getMonthOfBirth() == LocalDateTime.now().getMonthValue()){
                System.out.printf("Birthmonth bonus! earned $%,.2f%n%n", currentEmployee.getPaymentAmount() + 100);
                continue;
            }

            System.out.printf(
                    "earned $%,.2f%n%n", currentEmployee.getPaymentAmount());
        }

        // get type name of each object in employees array
        for (int j = 0; j < employees.length; j++) {
            System.out.printf("Employee %d is a %s%n", j+1,
                    employees[j].getClass().getName());
        }
    }
}