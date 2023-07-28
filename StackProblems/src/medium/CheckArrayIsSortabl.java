package medium;

import java.util.Stack;

public class CheckArrayIsSortabl {
    public static void main(String[] agrd) {
        int arr[] = {3, 2, 1,4};
        System.out.print(isSortable(arr));

    }

    public static boolean isSortable(int[] arr) {
        int counter = 0;
        Stack<Integer> stack = new Stack<>();
        int[] b = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (!stack.isEmpty() && stack.peek() < arr[i]) {
                b[counter] = stack.pop();
                counter++;
            } else {
                stack.push(arr[i]);
                arr[i] = -1;
            }
        }
        while (stack.isEmpty()) {
            b[counter] = stack.pop();
            counter++;
        }

        for (int i = 0; i < arr.length - 1; i++) {
            if (b[i] > b[i + 1]) {
                return false;
            }
        }
        return true;
    }

}
