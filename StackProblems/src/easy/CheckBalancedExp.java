package easy;

import java.util.Stack;

public class CheckBalancedExp {
    public static void main(String[] args) {
        String exp = "{()}[]{()";
        System.out.println(checkExp(exp));

    }

    public static boolean checkExp(String exp) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < exp.length(); i++) {
            Character x = exp.charAt(i);
            if (x == '(' || x == '{' || x == '[') {
                stack.push(x);
                continue;
            }
            if (stack.isEmpty())
                return false;
            switch (x){
                case ')':
                    if(stack.peek()=='('){
                        stack.pop();
                        continue;
                    } else {
                        return false;
                    }
                case '}':
                    if(stack.peek()=='{'){
                        stack.pop();
                        continue;
                    } else {
                        return false;
                    }
                case ']':
                    if(stack.peek()=='['){
                        stack.pop();
                        continue;
                    } else {
                        return false;
                    }
            }
        }
        return stack.isEmpty();
    }
}
