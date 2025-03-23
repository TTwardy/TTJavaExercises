package Chapter14.longestword;

import Chapter14.ReverseWords.Sentence;

import java.util.Scanner;

public class LongestWordMain {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a sentence");
        Sentence sentence = new Sentence(scanner.nextLine());
        System.out.println("The longest word is "+sentence.findLongestWord());

    }

}
