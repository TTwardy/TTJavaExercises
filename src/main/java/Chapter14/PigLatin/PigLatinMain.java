package Chapter14.PigLatin;

import java.util.List;
import java.util.Scanner;

public class PigLatinMain {
    public static void main(String[] args) {
        Methods methods = new Methods();
        String inputWord;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a word");

        while (true){
            inputWord = scanner.nextLine();
                if (inputWord.isBlank()){
                    System.out.println("please enter a word or a sentence");
                }
                else {
                    break;
                }
        }



        List<String> pigLatin = methods.moveFirstLetter(methods.tokenizeWords(inputWord));
        for(String word : pigLatin){
            word += "ay";
            System.out.println(word);
        }
    }


}
