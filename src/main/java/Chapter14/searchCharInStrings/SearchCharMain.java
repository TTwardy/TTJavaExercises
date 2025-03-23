package Chapter14.searchCharInStrings;

import Chapter14.ReverseWords.Sentence;

import java.util.Scanner;

public class SearchCharMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char character;

        while(true){
            System.out.println("Enter a character to search for in the sentence");
            String input = scanner.next();
            if (input.length()>1){
                System.out.println("enter a single character");
            }
            else {
                character = input.charAt(0);
                break;
            }
        }

        System.out.println("Enter a sentence where the char will be searched");
        Sentence sentence = new Sentence(scanner.next());

        System.out.printf("The characters appeared in the sentence %d times", sentence.countCharOcurrences(character));

    }
}
