package deque;
import java.util.Comparator;

public class MaxArrayDeque<T> extends ArrayDeque<T> {
    private Comparator<T> defaultComparator;

    public MaxArrayDeque(Comparator<T> c) {
        super();
        defaultComparator = c;
    }

    public T max() {
        if (size() == 0) {
            return null;
        }
        T maxItem = get(0);
        for (T i : this) {
            if (defaultComparator.compare(maxItem, i) < 0) {
                maxItem = i;
            }
        }
        return maxItem;
    }
    public T max(Comparator<T> c) {
        if (size() == 0) {
            return null;
        }
        T maxItem = get(0);
        for (T i : this) {
            if (c.compare(maxItem, i) < 0) {
                maxItem = i;
            }
        }
        return maxItem;
    }

//    /**My Integer Comparator. */
//    private static class IntComparator implements Comparator<Integer> {
//        @Override
//        public int compare(Integer a, Integer b){
//            return a - b;
//        }
//    }
//
//    public static Comparator<Integer> getIntComparator(){
//        return new IntComparator();
//    }

}
