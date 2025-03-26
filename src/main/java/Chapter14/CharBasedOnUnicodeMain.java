package Chapter14;

import java.util.Scanner;

import static Chapter14.ReverseWords.Sentence.printCharBasedOnUnicode;

public class CharBasedOnUnicodeMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number");
        int code = scanner.nextInt();

        printCharBasedOnUnicode(code);
    }
}
