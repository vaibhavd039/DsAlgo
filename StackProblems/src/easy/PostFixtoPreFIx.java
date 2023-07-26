package easy;

import java.util.Stack;

public class PostFixtoPreFIx {
    public static void main(String[] args) {
        String exp = "ABC/-AK/L-*";
        printPrefix(exp);
    }

    public static void printPrefix(String exp) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < exp.length(); i++) {
            Character x = exp.charAt(i);
            if (Character.isLetterOrDigit(x)) {
                stack.push(x + "");
            } else {
                if (!stack.isEmpty()) {
                    String exp1 =stack.pop();
                    String exp2 =stack.pop();
                    String temp = x+exp2+exp1;
                    stack.push(temp);
                }
            }
        }
        System.out.println(stack.pop());
    }

}
