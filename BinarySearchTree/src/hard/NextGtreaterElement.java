package hard;

import java.util.Arrays;
import java.util.TreeSet;

public class NextGtreaterElement {
    public static void main(String[] args) {

        int[] arr = {8, 58, 71, 18, 31, 32, 63, 92,
                43, 3, 91, 93, 25, 80, 28};
        getNextElement(arr);
        Arrays.stream(arr).forEach(element->System.out.print(element+"\t"));
    }

    public static void getNextElement(int[] arr) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            set.add(arr[i]);
            Integer next = set.higher(arr[i]);
            if (next == null) {
                arr[i] = -1;
            } else {
                arr[i] = next;
            }

        }
    }
}
