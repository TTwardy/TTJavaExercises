package Chapter9;


public class CommissionEmployeeTest {
        public static void main(String[] args) {
            // instantiate BasePlusCommissionEmployee object
            BasePlusCommissionEmployee baseEmployee =
                    new BasePlusCommissionEmployee(
                            "Bob", "Lewis", "333-33-3333", 5000, .04, 300);

            // get base-salaried commission employee data
            System.out.println(
                    "Employee information obtained by get methods:%n");
            System.out.printf("%s %s%n", "First name is",
                    baseEmployee.employee.getFirstName());
            System.out.printf("%s %s%n", "Last name is",
                    baseEmployee.employee.getLastName());
            System.out.printf("%s %s%n", "Social security number is",
                    baseEmployee.employee.getSocialSecurityNumber());
            System.out.printf("%s %.2f%n", "Gross sales is",
                    baseEmployee.employee.getGrossSales());
            System.out.printf("%s %.2f%n", "Commission rate is",
                    baseEmployee.employee.getCommissionRate());
            System.out.printf("%s %.2f%n", "Base salary is",
                    baseEmployee.getBaseSalary());

            baseEmployee.setBaseSalary(1000);

            System.out.printf("%n%s:%n%n%s%n",
                    "Updated employee information obtained by toString",
                    baseEmployee.toString());
        }
    }

