package medium;


import java.util.Stack;

public class LargestRactangularArea {
    public static void main(String[] args) {
        int hist[] = { 6, 2, 5, 4, 5, 2, 6 };
        System.out.print(getArea(hist));
    }

    public static int getArea(int[] hist) {
        int i = 0;
        int maxArea = Integer.MIN_VALUE;
        Stack<Pair> stack = new Stack<>();
        while (i < hist.length) {
            int height = hist[i];
            while (!stack.isEmpty() && stack.peek().value > height) {
                Pair element = stack.pop();
                int area = element.value* (stack.isEmpty()? i: (i - stack.peek().index -1));
                maxArea = Math.max(area, maxArea);
            }
            stack.push(new Pair(hist[i],i));
            i++;
        }
        return maxArea;
    }

}
