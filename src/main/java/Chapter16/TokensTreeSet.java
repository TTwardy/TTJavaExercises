package Chapter16;

import java.util.Arrays;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

public class TokensTreeSet {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a sentence to tokenize");
        String sentence = scanner.nextLine();

        SortedSet<String> tokens = new TreeSet<>(Arrays.asList(sentence.split("\\s+")));

        System.out.println(tokens);
    }
}
