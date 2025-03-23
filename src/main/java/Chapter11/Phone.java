package Chapter11;

public class Phone {
    String name;
    String serialNumber;
    public Phone(String name, String serialNumber) throws ValidationException{
        if (name.isBlank()||serialNumber.isBlank()||serialNumber.length()!=16){
            throw new ValidationException();
        } else {
                this.name=name;
                this.serialNumber=serialNumber;
        }

    }
}
