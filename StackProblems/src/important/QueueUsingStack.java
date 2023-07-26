package important;

import java.util.Stack;

public class QueueUsingStack {
    Stack<Integer> stack1;
    Stack<Integer> stack2;

    QueueUsingStack() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public static void main(String[] args) {
        QueueUsingStack queue = new QueueUsingStack();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());

    }

    public void enqueue(Integer a) {
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        stack1.push(a);
        while(!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
    }

    public int poll() {
        if(stack1.isEmpty()){
           throw  new RuntimeException("No Data Available");
        }
        return stack1.pop();
    }

}
