package Chapter16;

import java.util.*;

public class SetOperations {
    public static void main(String[] args) {

        Set<Integer> set1 = Set.of(1, 2, 3,7,8);
        Set<Integer> set2 = Set.of(1, 2, 3, 4, 5,7);

//        setInteraction(set1, set2);
//        setUnion(set1, set2);
        System.out.println(setDifference(set1, set2));
    }


    public static Set<Integer> setInteraction(Set<Integer> set1, Set<Integer> set2) {
//        ArrayList<Integer> interactionArray = new ArrayList<>();
//        Iterator<Integer> iteratorSet1 = set1.iterator();
//
//        while (iteratorSet1.hasNext()) {
//            int value = iteratorSet1.next();
//            if (set2.contains(value))
//                interactionArray.add(value);
//        }

        Set<Integer> result = new HashSet<>(set1);
        result.retainAll(set2);
        return result;
    }

    public static Set<Integer> setUnion(Set<Integer> set1, Set<Integer> set2){
        Set<Integer> unionSet = new HashSet<>(set1);
        unionSet.addAll(set2);
        return unionSet;
    }

    public static Set<Integer> setDifference(Set<Integer> set1, Set<Integer> set2) {
        Set<Integer> result = new HashSet<>(set1);
        result.addAll(set2);

        Set<Integer> common = new HashSet<>(set1);
        common.retainAll(set2);

        result.removeAll(common);
        return result;
    }

}
