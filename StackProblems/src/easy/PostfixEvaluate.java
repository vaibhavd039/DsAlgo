package easy;

import java.util.Stack;

public class PostfixEvaluate {
    public static void main(String[] args) {
        String exp = "231*+9-";
        System.out.println(isValid(exp));
    }

    public static int isValid(String exp) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < exp.length(); i++) {
            Character x = exp.charAt(i);
            if (Character.isDigit(x)) {
                stack.push(Character.getNumericValue(x));
            } else {
                if (!stack.isEmpty()) {
                    int a = stack.pop();
                    int b = stack.pop();
                    int val = 0;
                    switch (x) {
                        case '+':
                            val = a + b;
                            break;
                        case '-':
                            val = b - a;
                            break;
                        case '*':
                            val = b * a;
                            break;
                        case '%':
                            val = b % a;
                            break;
                        case '/':
                            val = b / a;
                            break;
                    }
                    stack.push(val);
                }
            }
        }
        int val = stack.pop();
        if (stack.isEmpty()) {
            return val;
        } else {
            return -1;
        }
    }

}
