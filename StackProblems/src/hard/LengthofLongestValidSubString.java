package hard;

import java.util.Stack;

public class LengthofLongestValidSubString {
    public static void main(String[] args) {
        String expression = "()))))";
        System.out.print(getMax(expression));
    }

    public static int getMax(String exp) {
        int maxLength = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < exp.length(); i++) {
            Character x = exp.charAt(i);
            if (x == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (!stack.isEmpty()) {
                    int result = i - stack.peek();
                    maxLength = Math.max(maxLength, result);
                } else {
                    stack.push(i);
                }
            }
        }
        return maxLength;
    }

}
