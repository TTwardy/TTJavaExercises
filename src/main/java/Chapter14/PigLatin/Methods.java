package Chapter14.PigLatin;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Methods {

    protected String [] tokenizeWords(String words){
        Objects.requireNonNull(words,"argument cannot be null");
        return words.split("\\s+");
    }
    protected List<String> moveFirstLetter (String [] tokenizedWords){
        Objects.requireNonNull(tokenizedWords,"argument cannot be null");

        List<String> wordsMovedLetters = new ArrayList<>();
        for (String word : tokenizedWords){
            word = word+word.charAt(0);
            word = word.replaceFirst("\\b\\w","");
            wordsMovedLetters.add(word);
        }
        return wordsMovedLetters;
    }
}
