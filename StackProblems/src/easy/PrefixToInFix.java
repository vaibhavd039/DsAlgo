package easy;

import java.util.Stack;

public class PrefixToInFix {
    public static void main(String[] args) {
        String exp = "*-A/BC-/AKL";
        preFixToInFix(exp);
    }

    public static void preFixToInFix(String exp) {
        Stack<String> mystack = new Stack<>();
        for (int i = exp.length()-1; i >= 0; i--) {
            if (Character.isLetterOrDigit(exp.charAt(i))) {
                mystack.push(String.valueOf(exp.charAt(i)));
            } else {
                if(!mystack.isEmpty()){
                    String exp1= mystack.pop();
                    String exp2= mystack.pop();
                    String temp = "(" + exp1 + exp.charAt(i) + exp2 + ")";
                    mystack.push(temp);
                }
            }
        }
        System.out.println(mystack.pop());
    }
}
