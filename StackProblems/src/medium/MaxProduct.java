package medium;

import java.util.Stack;

class CustomPair {
    int value;
    int index;

    CustomPair(int value, int index) {
        this.value = value;
        this.index = index;
    }
}

public class MaxProduct {
    public static void main(String[] args) {
        int[] arr = new int[]{5, 4, 3, 4, 5};
        int[] left = getNextElementLeft(arr);
        int[] right = getNextElementRight(arr);
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int temp = left[i] * right[i];
            max = Math.max(temp, max);
        }
        System.out.print(max);
    }

    public static int[] getNextElementRight(int[] arr) {
        int[] ans = new int[arr.length];
        Stack<CustomPair> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && stack.peek().value < arr[i]) {
                CustomPair pair = stack.pop();
                ans[pair.index] = Math.abs(i - pair.index)+1;
            }
            stack.push(new CustomPair(arr[i], i));
        }
        while (!stack.isEmpty()) {
            CustomPair pair = stack.pop();
            ans[pair.index] = -1;
        }
        return ans;
    }

    public static int[] getNextElementLeft(int[] arr) {
        int[] ans = new int[arr.length];
        Stack<CustomPair> stack = new Stack<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek().value < arr[i]) {
                CustomPair pair = stack.pop();
                ans[pair.index] = Math.abs(i - pair.index)+1;
            }
            stack.push(new CustomPair(arr[i], i));
        }
        while (!stack.isEmpty()) {
            CustomPair pair = stack.pop();
            ans[pair.index] = -1;
        }
        return ans;
    }

}
