package Chapter14;

import java.util.InputMismatchException;
import java.util.Scanner;

public class StringRegionMatchesExercise {
    String firstString;
    String secondString;
    int numOfCharactersToCompare;
    int startingIndex;
    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        StringRegionMatchesExercise exercise = new StringRegionMatchesExercise();


        exercise.firstString = exercise.promptString("enter the first String");
        exercise.secondString = exercise.promptString("enter the second String");
        exercise.startingIndex = exercise.promptInt(true, "Enter starting index");
        exercise.numOfCharactersToCompare = exercise.promptInt(false, "Enter number of chars to compare");


        if (!exercise.compareStrings(exercise.firstString, exercise.secondString, exercise.startingIndex, exercise.numOfCharactersToCompare)) {
            System.out.println("Substrings are not equal");
        } else {
            System.out.println("Substrings are equal");
        }


    }

    public String promptString(String promptMessage) {
        String input;
        while (true) {
            System.out.println(promptMessage);
            input = scanner.nextLine().trim();
            if (!input.isEmpty()) {
                break;
            } else {
                System.out.println("Input cannot be empty");
            }
        }
        return input;
    }

    public int promptInt(boolean isIndex, String promptMessage) {
        int input;
        while (true) {
            try {
                System.out.println(promptMessage);
                input = scanner.nextInt();
                if (isIndex) {
                    if (input >= firstString.length() || input < 0 || input >= secondString.length()) {
                        System.out.println("enter correct index");
                        scanner.nextLine();
                    } else {
                        break;
                    }
                } else {
                    if (input > firstString.length() || input < 0 || input > secondString.length() || startingIndex + input > firstString.length() ||  startingIndex + input > secondString.length()) {
                        System.out.println("enter correct number of chars");
                        scanner.nextLine();
                    } else {
                        break;
                    }
                }
            } catch (InputMismatchException inputMismatchException) {
                System.out.println("input mismatch caught. Enter a number");
                scanner.nextLine();
            }
        }
        scanner.nextLine();
        return input;


    }

    public boolean compareStrings(String firstString, String secondString, int startingIndex, int numOfCharactersToCompare) {
        System.out.println(firstString.substring(startingIndex, startingIndex + numOfCharactersToCompare));
        System.out.println(secondString.substring(startingIndex, startingIndex + numOfCharactersToCompare));
        return firstString.regionMatches(true, startingIndex, secondString, startingIndex, numOfCharactersToCompare);
    }
}
