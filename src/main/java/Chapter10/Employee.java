package Chapter10;
import Chapter8.Date;

public abstract class Employee implements Payable{
    private final String firstName;
    private final String lastName;
    private final String socialSecurityNumber;
    private final Date dateOfBirth;

    // constructor
    public Employee(String firstName, String lastName,
                    String socialSecurityNumber, int year, int month, int day) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.socialSecurityNumber = socialSecurityNumber;
        this.dateOfBirth = new Date(year,month,day);
    }

    // return first name
    public String getFirstName() {return firstName;}

    // return last name
    public String getLastName() {return lastName;}

    // return social security number
    public String getSocialSecurityNumber() {return socialSecurityNumber;}

    // return String representation of Employee object
    @Override
    public String toString() {
        return String.format("%s %s%nsocial security number: %s",
                getFirstName(), getLastName(), getSocialSecurityNumber());
    }

    // abstract method must be overridden by concrete subclasses
    public abstract double getPaymentAmount(); // no implementation here
    public int getMonthOfBirth(){
        return dateOfBirth.getMonthOfBirth();
    }
}