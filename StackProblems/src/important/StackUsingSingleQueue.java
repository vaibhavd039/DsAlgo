package important;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingSingleQueue {
    Queue<Integer> queue;

    StackUsingSingleQueue() {
        queue = new LinkedList<>();
    }

    public static void main(String[] args) {
        StackUsingSingleQueue stack = new StackUsingSingleQueue();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack.pop());

        System.out.println(stack.pop());

        System.out.println(stack.pop());
    }

    public void push(int x){
        if(queue.isEmpty()){
            queue.add(x);
            return;
        }
        queue.add(x);
        for(int i =0;i<queue.size()-1;i++){
            int temp = queue.poll();
            queue.add(temp);
        }
    }

    public int pop(){
        return queue.poll();
    }
}
