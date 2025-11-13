package Chapter16;

import java.util.*;

public class CountingDuplicateWords {
    public static void main(String[] args) {

        Map<String, Integer> duplicatesMap = new HashMap<>();
        String sentence = "Two houses on a hill. Three houses in a chasm. Seven hills in a chasm.";
        sentence=sentence.replaceAll("[.,!?;:]", "").toLowerCase();

        List<String> list = new ArrayList<>();
        list.addAll(Arrays.asList(sentence.split("\\s")));


        for (int i = 0; i < list.size(); i++) {
            int frequency = Collections.frequency(list, list.get(i));
            if(frequency>1){
                duplicatesMap.put(list.get(i), frequency);
            }
        }
        System.out.println(duplicatesMap);

    }
}
