package easy;

import java.util.Stack;

public class PostFixToInFIx {
    public static void main(String[] args) {
        String exp = "ab*c+";
        printInfix(exp);
    }

    public static void printInfix(String exp){
        Stack<String> mystack = new Stack<>();
        for(int i =0;i<exp.length();i++){
            Character x = exp.charAt(i);
            if(Character.isLetterOrDigit(x)){
                mystack.push(x+"");
            } else {
                if(!mystack.isEmpty()){
                    String ex1= mystack.pop();
                    String ex2= mystack.pop();
                    String expression = "("+ex2+x+ex1+")";
                    mystack.push(expression);
                }
            }
        }
        System.out.println(mystack.pop());
    }
}
