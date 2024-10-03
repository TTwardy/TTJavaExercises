package Chapter9;

public class Employee {
    private final String firstName;
    private final String lastName;
    private final String socialSecurityNumber;
    protected CompensationModel compensationModel;


    public Employee(String firstName, String lastName, String socialSecurityNumber, CompensationModel compensationModel) {
        // if commissionRate is invalid throw exception
        this.firstName = firstName;
        this.lastName = lastName;
        this.socialSecurityNumber = socialSecurityNumber;
        this.compensationModel = compensationModel;
    }
    public Employee(String firstName, String lastName, String socialSecurityNumber) {
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
                "commission employee", getFirstName(), getLastName(),
                "social security number", getSocialSecurityNumber()
                );
    }
}
