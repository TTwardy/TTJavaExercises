package Chapter14;

import java.util.Scanner;

public class Palindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word;

        while (true){

            System.out.println("Enter a word");
            word = scanner.nextLine();
            if (word.matches("[a-zA-Z]{2,}")){
                System.out.println("Is palindrome? : "+isPalindrome2(word));
                break;
            }
            else {
                System.out.println("Enter a valid String");
            }
        }



    }

    public static boolean isPalindrome(String word) {
        String firstHalfOfWord = word.substring(0, word.length() / 2);
        String revertedSecondHalf = new StringBuilder(word.substring((word.length()+1)/2)).reverse().toString();

       System.out.println(firstHalfOfWord);
       System.out.println(revertedSecondHalf);
//        System.out.println("inverted s h "+revertedSecondHalf);

        return firstHalfOfWord.equalsIgnoreCase(revertedSecondHalf);

    }

    public static boolean isPalindrome2(String word) {
        int left = 0;
        int right = word.length()-1;

        while(left<right){
            if(Character.toLowerCase(word.charAt(left)) != Character.toLowerCase(word.charAt(right))){
                return false;
            }
            else {
                left++;
                right--;
            }
        }
        return true;

    }
}
//radar