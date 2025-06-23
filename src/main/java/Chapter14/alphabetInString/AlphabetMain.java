package Chapter14.alphabetInString;

import Chapter14.ReverseWords.Sentence;

import java.util.Scanner;

public class AlphabetMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a sentence");
        Sentence sentence = new Sentence(scanner.nextLine());
        sentence.countAllCharacters();

        System.out.println("Char index: "+sentence.customIndexOf('a'));

    }
}
