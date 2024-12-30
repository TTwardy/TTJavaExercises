package Chapter10;

public class CompensationModelTest {
    public static void main(String[] args) {
        //CommissionCompensationModel compensation = new CommissionCompensationModel(1000, 0.1);
        EmployeeChapter9 employee = new EmployeeChapter9("Thomas", "Rodent", "1342",
                new CommissionCompensationModel(2000, 0.1));
        EmployeeChapter9 employee2 = new EmployeeChapter9("Roger", "Wermouse", "1342",
                new HourlyCompensationModel(20, 160));

        System.out.println("Commission only:" + employee.earnings());
        employee.setCompensationModel(new BasePlusCommissionCompensationModel(employee.compensationModel.getSales(), 0.1, 500));
        System.out.println("Base and commission:"+employee.earnings());
        employee.setCompensationModel(new CommissionCompensationModel(employee.compensationModel.getSales(), 0.4));
        System.out.println("Changed commission:"+employee.earnings());

        System.out.println("Hourly employee:"+employee2.earnings());
        employee2.setCompensationModel(new SalariedCompensationModel(3000));
        System.out.println("Salary employee:"+employee2.earnings());

        employee2.setCompensationModel(new HourlyCompensationModel(25,150));
        System.out.println("Hourly employee:"+employee2.earnings());
    }
}