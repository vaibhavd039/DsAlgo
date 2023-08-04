package hard;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElement {
    public static void main(String[] args) {
        int arr[] = {3, 4, 2, 7,
                5, 8, 10, 6};
        int query[] = {3, 6, 1};
        Map<Integer, Integer> mymap = getNextGreaterElement(arr);
        for(int i =0;i<query.length;i++){
            System.out.println(query[i]+" for this query next element is "+mymap.get(arr[query[i]]));
        }
    }

    public static Map<Integer, Integer> getNextGreaterElement(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        stack.push(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            int curr = arr[i];
            Integer element = stack.pop();
            while (element < curr) {
                map.put(element, curr);
                if(!stack.isEmpty()) {
                    element = stack.pop();
                } else {
                    break;
                }
            }
            if (element > curr) {
                stack.push(element);
            }
            stack.push(curr);
        }
        while (!stack.isEmpty()) {
            map.put(stack.pop(), -1);
        }
        return map;
    }

}
