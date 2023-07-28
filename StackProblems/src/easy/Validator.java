package easy;

import java.util.Stack;

public class Validator {
    public static void main(String[] args) {
        String test= "()";
        System.out.print(isValid(test));
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            Character x = s.charAt(i);
            if (x == '(' || x == '{' || x == '[') {
                stack.push(x);
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    Character y = stack.pop();
                    if (x == ')' && y != '(') {
                        return false;
                    } else if (x == '}' && y != '{') {
                        return false;
                    } else if (x == ']' && y != '[') {
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }
}
