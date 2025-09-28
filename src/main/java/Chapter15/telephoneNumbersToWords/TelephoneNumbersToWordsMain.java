package Chapter15.telephoneNumbersToWords;

import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.HashMap;
import java.util.Scanner;

public class TelephoneNumbersToWordsMain {
    public static void main(String[] args) throws FileNotFoundException {

        NumberToWordsProcessor numberToWordsProcessor = new NumberToWordsProcessor(requestTelephoneNumber());

        try (Formatter formatter = new Formatter("wordFromNumbers.txt")){
            numberToWordsProcessor.generateCombinations(0,"", formatter);
        }
    }

    protected static String requestTelephoneNumber(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the telephone number");
        while (true){
            if (scanner.hasNextInt()){
                return scanner.nextLine();
            }
            else {
                System.out.println("Enter correct number");
                scanner.nextLine();
            }
        }

        //add validations
    }
}
