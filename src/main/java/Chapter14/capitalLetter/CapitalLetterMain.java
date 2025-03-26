package Chapter14.capitalLetter;

import Chapter14.ReverseWords.Sentence;

import java.util.Scanner;

public class CapitalLetterMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a sentence");
        Sentence sentence = new Sentence(scanner.nextLine());
        sentence.printWordsEndingWithED();
        sentence.printWordsWithCapitalLetter();

    }
}
