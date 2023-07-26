package important;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {
    Queue<Integer> queue1;
    Queue<Integer> queue2;

    StackUsingQueue() {
        this.queue1 = new LinkedList<>();
        this.queue2 = new LinkedList<>();
    }

    public static void main(String [] args) {
        StackUsingQueue stack = new StackUsingQueue();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack.top());
        System.out.println(stack.pop());
        System.out.println(stack.top());

    }

    public void push(int x){
        while(!queue1.isEmpty()){
            queue2.add(queue1.poll());
        }
        queue1.add(x);
        while(!queue2.isEmpty()){
            queue1.add(queue2.poll());
        }
    }

    public int top(){
        if(queue1.isEmpty())
            return -1;
        return queue1.peek();
    }

    public int pop(){
        if(queue1.isEmpty())
            return -1;
        return queue1.poll();
    }
}
