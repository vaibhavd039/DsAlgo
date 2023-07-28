package medium;

import java.util.Stack;

public class LargestRectangle {
    public static void main(String[] args) {
        int arr[] =  { 6, 2, 5, 4, 5, 1, 6 };
        System.out.print(getMaxArea(arr));
    }

    public static int getMaxArea(int[] hist) {
        int i =0;
        int maxArea = Integer.MIN_VALUE;
        Stack<Pair> stack = new Stack<>();
        while (i < hist.length) {
            int height = hist[i];
            while (!stack.isEmpty() && stack.peek().value > height) {
                Pair element = stack.pop();
                int area = element.value* (stack.isEmpty() ? i: (i - stack.peek().index -1));
                maxArea = Math.max(area, maxArea);
            }
            stack.push(new Pair(hist[i],i));
            i++;
        }
        return  maxArea;
    }
}
