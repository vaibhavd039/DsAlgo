package important;

import java.util.Stack;

public class MinSTack extends Stack<Integer> {
    Stack<Integer> min = new Stack<>();
    public static void main(String [] args){
        MinSTack stack = new MinSTack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println(stack.getMin());
        System.out.println(stack.pop());
        System.out.println(stack.getMin());
    }

    public void push(int x) {
        if (isEmpty()) {
            super.push(x);
            min.push(x);
        } else {
            int y = min.peek();
            min.push(y);

            super.push(x);
            if (x < y) {
                min.push(x);
            }
        }
    }

    public int getMin() {
        return min.peek();
    }

    public Integer pop() {
        int x = super.pop();
        if (x == min.peek()) {
            min.pop();
        }
        return x;
    }
}

