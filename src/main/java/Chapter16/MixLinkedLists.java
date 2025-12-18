package Chapter16;

import java.util.LinkedList;
import java.util.List;

public class MixLinkedLists {
    protected static <E> List<E> mixLists (List<E> firstList, List<E> secondList){
        List<E> mixedList = new LinkedList<>();
        int maxIndex = Math.max(firstList.size(), secondList.size());

        for (int i = 0; i < maxIndex; i++) {

            if (i< firstList.size()){
                mixedList.add(firstList.get(i));
            }
            if (i< secondList.size()){
                mixedList.add(secondList.get(i));
            }
        }
        return mixedList;
    }
}
