package hard;

import java.util.Stack;

public class RedundantParanthesis {
    public static void main(String[] args) {
        String str = "((a+b))";
        System.out.print(checkParantheses(str));
    }

    public static boolean checkParantheses(String exp) {
        boolean hasRedundant = false;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < exp.length(); i++) {
            Character x = exp.charAt(i);
            if (x == ')') {
                Character top = stack.pop();
                hasRedundant = true;
                while (top != '(') {
                    if (top == '+' || top == '-' || top == '*' || top == '/') {
                        hasRedundant = false;
                    }
                    top = stack.pop();
                }
                if (hasRedundant == true) {
                    return true;
                }
            } else {
                stack.push(x);
            }
        }
        return false;
    }
}
