package easy;

import java.util.Stack;

public class ReverseStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.push(7);
        reverse(stack);
        System.out.println(stack.pop());

        System.out.println(stack.pop());

        System.out.println(stack.pop());

        System.out.println(stack.pop());

    }

    public  static void reverse(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            int x = stack.pop();
            reverse(stack);
            insert(stack, x);
        }
    }

    public static void insert(Stack<Integer> stack, int x){
        if(stack.isEmpty()){
            stack.push(x);
            return;
        }
        int y = stack.pop();
        insert(stack,x);
        stack.push(y);
    }

}
