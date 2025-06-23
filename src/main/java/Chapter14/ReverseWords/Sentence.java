package Chapter14.ReverseWords;

import java.util.*;

public class Sentence {
    String sentence;
    String [] tokenizedSentence;
    public Sentence(String sentence){
        this.sentence = Objects.requireNonNull(sentence,"Sentence cannot be empty");
        tokenizedSentence = tokenizeSentence();
    }
    protected String[] tokenizeSentence (){
        return sentence.split("\\s+");
    }
    protected void createReversedSentence(){
        StringBuilder reversedSentence = new StringBuilder();

        for(String s : tokenizedSentence){
            for (int i = s.length()-1; i >= 0; i--) {
                reversedSentence.append(s.charAt(i));
            }
            reversedSentence.append(" ");
        }
        sentence = reversedSentence.toString();
    }
    public String findLongestWord(){
        StringBuilder longestWord = new StringBuilder();
        for (String s : tokenizedSentence){
            if (s.length()>=longestWord.length()){
                longestWord.setLength(0);
                longestWord.append(s);
            }
        }
        return longestWord.toString();
    }

    public int countCharOcurrences(char character){
        if(sentence==null){
            return 0;
        }
        int counter = 0;
        for (int i = 0; i <= sentence.length()-1 ; i++) {
            if (Character.toLowerCase(sentence.charAt(i))==Character.toLowerCase(character)){
                counter++;
            }
        }
        return counter;
    }

    public void countAllCharacters () {
        sentence = sentence.replaceAll("\\s+","");

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i <= sentence.length()-1 ; i++) {
            char currentChar = sentence.charAt(i);
            if (map.containsKey(currentChar)){
                map.put(currentChar, map.get(currentChar)+1);
            }
            else {
                map.put(currentChar,1);
            }
        }
        System.out.println(map.toString());
    }

    public void printWordsWithCapitalLetter (){
        for (String s : tokenizedSentence){
            if(Character.isUpperCase(s.charAt(0))){
                System.out.println(s);
            }
        }
    }
    public void printWordsEndingWithED (){
        for (String s : tokenizedSentence){
            if(s.toLowerCase().endsWith("ed")){
                System.out.println(s);
            }
        }
    }

    public static void printCharBasedOnUnicode(int code){
        System.out.println((char) code);
    }

    public static void generatePermutations(String current, List<Character> available, Set<String> result) {
        // Base case: If the current string reaches length 3, store it
        if (current.length() == 3) {
            result.add(current);
            return; // Stop further recursion
        }

        // Loop through available characters
        for (int i = 0; i < available.size(); i++) {
            // Choose a character
            char chosen = available.get(i);

            // Create a new list without the chosen character
            List<Character> remaining = new ArrayList<>(available);
            remaining.remove(i);

            // Recurse with the new word and remaining letters
            generatePermutations(current + chosen, remaining, result);
        }
    }


    public int customIndexOf (char character){
        for (int i = 0; i<=sentence.length()-1; i++){
            if (sentence.charAt(i)==character){
                return i;
            }
        }
        return -1;
    }
    @Override
    public String toString() {
        return sentence;
    }
}
