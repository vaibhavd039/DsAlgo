package easy;

import base.Precedence;

import java.util.Stack;

public class InfixToPostFix {
    public static void main(String[] args) {
        String exp = "a+b*(c^d-e)^(f+g*h)-i";
        printPostFix(exp);
    }

    public static void printPostFix(String exp) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < exp.length(); i++) {
            Character x = exp.charAt(i);
            if (Character.isLetterOrDigit(x)) {
                result.append(x);
            } else if (x == '(') {
                stack.push(x);
            } else if (x == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result.append(stack.pop());
                }
                stack.pop();
            }
            else {
                while (!stack.isEmpty() && Precedence.getPrecedence(x) <= Precedence.getPrecedence(stack.peek())) {
                    result.append(stack.pop());
                }
                stack.push(x);
            }
        }

        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        System.out.println(result);
    }

}
