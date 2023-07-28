package medium;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;


class Pair {
    int value;
    int index;

    Pair(int value, int frequency) {
        this.index = frequency;
        this.value = value;
    }
}

public class NextGreaterFrequencyElement {
    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 2, 2, 2, 2, 11, 3, 3};
        int[] ans = getNextGreateFrequncey(arr);
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + "\t");
        }
    }

    public static int[] getNextGreateFrequncey(int[] arr) {
        int[] ans = new int[arr.length];
        Map<Integer, Integer> mymap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            mymap.putIfAbsent(arr[i], 0);
            int frequncy = mymap.get(arr[i]) + 1;
            mymap.put(arr[i], frequncy);
        }
        Stack<Pair> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while ((!stack.isEmpty() && mymap.get(stack.peek().value) < mymap.get(arr[i]))) {
                Pair pair = stack.pop();
                ans[pair.index] = arr[i];
            }
            stack.push(new Pair(arr[i], i));
        }
        while (!stack.isEmpty()) {
            Pair pair = stack.pop();
            ans[pair.index] = -1;
        }
        return ans;
    }
}
