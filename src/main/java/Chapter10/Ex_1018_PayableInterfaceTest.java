package Chapter10;

public class Ex_1018_PayableInterfaceTest {
    public static void main(String[] args) {
        // create four-element Payable array
        Payable[] payableObjects = new Payable[]{
                new Invoice("01234", "seat", 2, 375.00),
                new Invoice("56789", "tire", 4, 79.95),
                new EmployeeChapter9("Christopher", "Landlord", "56453", new SalariedCompensationModel(8000)),
                new EmployeeChapter9("Karen", "Last", "111", new HourlyCompensationModel(40, 150)),
                new EmployeeChapter9("bob", "Dylan", "3456", new BasePlusCommissionCompensationModel(20000, 0.20, 1000)),
        };

        System.out.println(
                "Invoices and Employees processed polymorphically:");

        for (Payable currentPayable : payableObjects) {
            if (currentPayable instanceof BasePlusCommissionEmployee) {
                BasePlusCommissionEmployee basePlusCommissionEmployee = (BasePlusCommissionEmployee) currentPayable;
                basePlusCommissionEmployee.setBaseSalary(basePlusCommissionEmployee.getBaseSalary() * 1.1);
            }
        }
        // generically process each element in array payableObjects
        for (Payable currentPayable : payableObjects) {
            // output currentPayable and its appropriate payment amount
            if (currentPayable.getClass().getName().equals("BasePlusCommissionEmployee")) {
                System.out.printf("%n%s %n payment due: $%,.2f%n",
                        currentPayable, // could invoke implicitly
                        currentPayable.getPaymentAmount() * 1.1);
            } else {
                System.out.printf("%n%s %n payment due: $%,.2f%n",
                        currentPayable, // could invoke implicitly
                        currentPayable.getPaymentAmount());
            }
        }
    }
}
