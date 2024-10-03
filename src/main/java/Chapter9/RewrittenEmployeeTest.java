package Chapter9;

public class RewrittenEmployeeTest {
    public static void main(String[] args) {
        //CommissionCompensationModel compensation = new CommissionCompensationModel(1000, 0.1);
        Employee employee = new Employee("Thomas", "Rodent", "1342",
                new CommissionCompensationModel(2000, 0.1));

        System.out.println("Commission only:"+employee.earnings());
        employee.setCompensationModel(new BasePlusCommissionCompensationModel(employee.compensationModel.grossSales, 0.1, 500));
        System.out.println("Base and commission:"+employee.earnings());
        employee.setCompensationModel(new CommissionCompensationModel(employee.compensationModel.grossSales, 0.4));
        System.out.println("Changed commission:"+employee.earnings());


        // instantiate BasePlusCommissionEmployee object
//        ReWrtCommissionEmployee ReWrtCommissionEmployee =
//                new ReWrtCommissionEmployee(
//                        "Bob", "Lewis", "333-33-3333", 5000, .04300);
//
//        // get base-salaried commission employee data
//        System.out.println(
//                "Employee information obtained by get methods:%n");
//        System.out.printf("%s %s%n", "First name is",
//                ReWrtCommissionEmployee.getFirstName());
//        System.out.printf("%s %s%n", "Last name is",
//                ReWrtCommissionEmployee.getLastName());
//        System.out.printf("%s %s%n", "Social security number is",
//                ReWrtCommissionEmployee.getSocialSecurityNumber());
//        System.out.printf("%s %.2f%n", "Gross sales is",
//                ReWrtCommissionEmployee.getGrossSales());
//        System.out.printf("%s %.2f%n", "Commission rate is",
//                ReWrtCommissionEmployee.getCommissionRate());
//
//        System.out.print(ReWrtCommissionEmployee);
    }
}
