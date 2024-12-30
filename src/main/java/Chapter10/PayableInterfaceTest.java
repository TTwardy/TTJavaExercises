package Chapter10;

public class PayableInterfaceTest {
    public static void main(String[] args) {
        // create four-element Payable array
        Payable[] payableObjects = new Payable[] {
                new Invoice("01234", "seat", 2, 375.00),
                new Invoice("56789", "tire", 4, 79.95),
                new SalariedEmployee("John", "Smith", "111-11-1111", 800.00, 1991, 11, 25),
                new HourlyEmployee("Karen", "Price", "222-22-2222", 16.75, 40,1977, 4, 5),
                new BasePlusCommissionEmployee("Bob", "Lewis", "444-44-4444", 5000, .04, 300,1999, 11, 25),
                new PieceWorker("Adam", "Grave", "233-423-555", 1980, 6, 22, 100, 14)
        };

        System.out.println(
                "Invoices and Employees processed polymorphically:");

        for (Payable currentPayable : payableObjects) {
            if (currentPayable instanceof BasePlusCommissionEmployee) {
                BasePlusCommissionEmployee basePlusCommissionEmployee = (BasePlusCommissionEmployee) currentPayable;
                basePlusCommissionEmployee.setBaseSalary(basePlusCommissionEmployee.getBaseSalary()*1.1);
            }
        }
        // generically process each element in array payableObjects
        for (Payable currentPayable : payableObjects) {
            // output currentPayable and its appropriate payment amount
            if (currentPayable.getClass().getName().equals("BasePlusCommissionEmployee")){
                System.out.printf("%n%s %n payment due: $%,.2f%n",
                        currentPayable, // could invoke implicitly
                        currentPayable.getPaymentAmount()*1.1);
            }
            else {
                System.out.printf("%n%s %n payment due: $%,.2f%n",
                        currentPayable, // could invoke implicitly
                        currentPayable.getPaymentAmount());
            }
        }
    }
}
