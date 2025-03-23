package Chapter14.ReverseWords;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

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

    @Override
    public String toString() {
        return sentence;
    }
}
