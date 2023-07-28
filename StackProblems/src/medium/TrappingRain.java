package medium;

import java.util.Stack;

public class TrappingRain {
    public static void main(String[] args) {
        int arr[] = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.print(getWater(arr));
    }


    public static int getWater(int[] arr) {
        int maxWater = 0;
        Stack<Pair> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[i] > stack.peek().value) {
                Pair element = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                int height = Math.min(arr[i], stack.peek().value) - element.value;
                int distance = i - stack.peek().index - 1;
                int water = height * distance;
                maxWater += water;
            }
            stack.push(new Pair(arr[i], i));
        }
        return maxWater;
    }

}
