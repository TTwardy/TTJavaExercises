package Chapter14.ReverseWords;

import java.util.Scanner;

public class ReverseWordsMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a sentence");
        Sentence sentence = new Sentence(scanner.nextLine());
        System.out.println("This is a sentence with reversed words");
        sentence.createReversedSentence();
        System.out.print(sentence);
    }
}
