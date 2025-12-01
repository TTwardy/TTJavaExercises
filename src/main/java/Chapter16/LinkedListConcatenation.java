package Chapter16;

import java.util.LinkedList;
import java.util.List;

public class LinkedListConcatenation {
    public static void main(String[] args) {
        LinkedList<String> list1 = new LinkedList<>(List.of("cream", "sword", "mountain"));
        LinkedList<String> list2 = new LinkedList<>(List.of("red", "sunset", "bear"));

        System.out.println(concatenateLists(list1, list2));
    }

    public static List<String> concatenateLists(LinkedList<String> list1, LinkedList<String> list2){
        LinkedList<String> concatonatedLists = new LinkedList<>(list1);
        concatonatedLists.addAll(list2);
        return concatonatedLists;
    }
}
