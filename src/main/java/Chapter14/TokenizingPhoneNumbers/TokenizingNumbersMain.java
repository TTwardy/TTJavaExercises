package Chapter14.TokenizingPhoneNumbers;

import java.util.Scanner;
//
//import static Chapter14.TokenizingPhoneNumbers.Methods.getAreaCode;
//import static Chapter14.TokenizingPhoneNumbers.Methods.tokenizePhoneNumber;

public class TokenizingNumbersMain {
    public static void main(String[] args) {

        Methods methods = new Methods();
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter a telephone number in the following form: (555) 555-5555");
        String phoneNumber = scanner.nextLine();

        System.out.printf("Final number: %s \n", methods.tokenizePhoneNumber(phoneNumber));
        System.out.println("Individual tokens");
        methods.printTokens();
    }
}
