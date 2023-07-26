package easy;

import base.Precedence;

import java.util.Stack;

public class InfixToPrefix {
    public static void main(String[] args) {
        String exp = "x+y*z/w+u";
        exp = reverseExpression(exp);
        String postFix  = getNearPostFix(exp);
        String newvalue = reverseExpression(postFix);
        System.out.println(newvalue);

    }

    public static String getNearPostFix(String exp) {
        StringBuilder result = new StringBuilder();
        Stack<Character> mystack = new Stack<>();
        for (int i = 0; i < exp.length(); i++) {
            Character x = exp.charAt(i);
            if (Character.isLetterOrDigit(x)) {
                result.append(x);
            } else if (x == '(') {
                mystack.push(x);
            } else if (x == ')') {
                while (!mystack.isEmpty() && mystack.peek() != '(') {
                    result.append(mystack.pop());
                }
                mystack.pop();
            } else {
                while (!mystack.isEmpty() && Precedence.getPrecedence(x) < Precedence.getPrecedence(mystack.peek())) {
                    result.append(mystack.pop());
                }
                mystack.push(x);
            }
        }
        while(!mystack.isEmpty()){
            result.append(mystack.pop());
        }
        return String.valueOf(result);
    }


    public static String reverseExpression(String exp) {
        StringBuilder result = new StringBuilder();
        result.append(exp);
        result.reverse();
        for (int i = 0; i < result.length(); i++) {
            if (result.charAt(i) == ')') {
                result.setCharAt(i, '(');
            } else if (result.charAt(i) == '(') {
                result.setCharAt(i, ')');
            }
        }
        return String.valueOf(result);
    }
}
