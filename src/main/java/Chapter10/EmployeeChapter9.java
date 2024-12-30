package Chapter10;

//modified in Ex 10.18
public class EmployeeChapter9 implements Payable{
    private final String firstName;
    private final String lastName;
    private final String socialSecurityNumber;
    protected CompensationModel compensationModel;


    public EmployeeChapter9(String firstName, String lastName, String socialSecurityNumber, CompensationModel compensationModel) {
        // if commissionRate is invalid throw exception
        this.firstName = firstName;
        this.lastName = lastName;
        this.socialSecurityNumber = socialSecurityNumber;
        this.compensationModel = compensationModel;
    }
    public EmployeeChapter9(String firstName, String lastName, String socialSecurityNumber) {
        // if commissionRate is invalid throw exception
        this.firstName = firstName;
        this.lastName = lastName;
        this.socialSecurityNumber = socialSecurityNumber;
    }

    protected void setCompensationModel(CompensationModel compensationModel){
        this.compensationModel=compensationModel;
    }

    protected double earnings(){
        return compensationModel.earnings();
    }


    // return first name
    public String getFirstName() {return firstName;}

    // return last name
    public String getLastName() {return lastName;}

    // return social security number
    public String getSocialSecurityNumber() {return socialSecurityNumber;}

    // return String representation of CommissionEmployee object
    @Override
    public String toString() {
        return String.format("%s: %s %s%n%s: %s%n",
                "Employee", getFirstName(), getLastName(),
                "social security number", getSocialSecurityNumber()
        );
    }

    @Override
    public double getPaymentAmount() {
        return compensationModel.earnings();
    }
}
