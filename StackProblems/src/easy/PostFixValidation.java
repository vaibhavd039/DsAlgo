package easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostFixValidation {
    public static  void main(String [] args){
        String [] arg = {"2","1","+","3","*"};
        System.out.print(evalRPN(arg));
        List<List<Integer>> result = new ArrayList<>();
    }
    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<tokens.length;i++){
            String x = tokens[i];
            if(!isOperator(x)){
                stack.push(Integer.valueOf(x));
            } else if(!stack.isEmpty()){
                int a = stack.pop();
                int b = stack.pop();
                int val =0;
                switch(x){
                    case "+":
                        val = b+a;
                        break;
                    case "-":
                        val = b-a;
                        break;
                    case "*":
                        val = b*a;
                        break;
                    case "/":
                        val = b/a;
                        break;

                }
                stack.push(val);
            }
        }
        return stack.pop();
    }

    public static boolean isOperator(String x){
        return x=="+" || x=="-" || x=="*" || x=="/";
    }
}
