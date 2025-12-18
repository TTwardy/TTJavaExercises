package Chapter16.SortingAccounts;

import java.util.Comparator;

public class DescendingComparator implements Comparator <Double> {
    @Override
    public int compare(Double o1, Double o2) {
        return Double.compare(o2, o1);
    }
}
