package medium;

import java.util.Stack;

public class SortStack {
    public static void main(String[] agrs) {
        Stack<Integer> mystacdk = new Stack<>();
        mystacdk.push(5);
        mystacdk.push(4);
        mystacdk.push(3);
        mystacdk.push(2);
        mystacdk.push(6);
        mystacdk.push(7);
        Stack<Integer> newStack = sort(mystacdk);
       newStack.stream().forEach(elment->{
           System.out.print(elment+"\t");
       });
    }

    public static Stack<Integer> sort(Stack<Integer> stack) {
        Stack<Integer> sorted = new Stack<>();
        while (!stack.isEmpty()) {
            int temp = stack.pop();
            while (!sorted.isEmpty() && sorted.peek() > temp) {
                stack.push(sorted.pop());
            }
            sorted.push(temp);
        }
        return sorted;
    }


}
