package easy;

import java.util.Stack;

public class ReverseWord {
    public static void main(String[] args) {
        String str = "Geeks for Geeks";
        printReverse(str);

    }

    public static void printReverse(String str) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            Character x=str.charAt(i);
            if(x==' '){
                while(!stack.isEmpty()){
                    System.out.print(stack.pop());
                }
                System.out.print(" ");
            } else {
                stack.push(x);
            }
        }
        while(!stack.isEmpty()){
            System.out.print(stack.pop());
        }
    }
}
