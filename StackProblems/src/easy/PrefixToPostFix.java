package easy;

import java.util.Stack;

public class PrefixToPostFix {
    public static void main(String[] args) {
        String pre_exp = "*-A/BC-/AKL";
        printPostFix(pre_exp);
    }

    public static void printPostFix(String exp) {
        Stack<String> stack = new Stack<>();
        for (int i = exp.length() - 1; i >= 0; i--) {
            Character x = exp.charAt(i);
            if (Character.isLetterOrDigit(x)) {
                stack.push(x + "");
            } else {
                if (!stack.isEmpty()) {
                    String exp1= stack.pop();
                    String exp2= stack.pop();
                    String temp = exp1+exp2+x;
                    stack.push(temp);
                }
            }

        }
        System.out.println(stack.pop());
    }
}
