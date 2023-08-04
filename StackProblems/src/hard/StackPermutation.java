package hard;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StackPermutation {
    public static void main(String[] args) {
        Queue<Integer> input = new LinkedList<>();
        input.add(1);
        input.add(2);
        input.add(3);
        Queue<Integer> output = new LinkedList<>();
        output.add(2);
        output.add(1);
        output.add(3);
        System.out.print(checkPermutation(input, output));
    }

    public static boolean checkPermutation(Queue<Integer> input, Queue<Integer> output) {
        Stack<Integer> stack = new Stack<>();
        while (!input.isEmpty()) {
            int element = input.poll();
            if (element == output.peek()) {
                    output.poll();
                    while(!stack.isEmpty()){
                        if(stack.peek()==output.peek()){
                            stack.pop();
                            output.peek();
                        } else {
                            break;
                        }
                    }
            } else {
                stack.push(element);
            }
        }
        return input.isEmpty() && stack.isEmpty();
    }

}
