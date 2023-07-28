package medium;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class DeleteConsecutive {
    public static void main(String[] args) {
        String[] arr = {"tom", "jerry", "jerry", "tom"};
        deleteConsecutive(arr);
        String[] brr = {"ab", "aa", "aa", "bcd"};
        deleteConsecutive(brr);
    }

    public static void deleteConsecutive(String[] arr) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if (stack.isEmpty()) {
                stack.push(arr[i]);
            } else {
                if (stack.peek().equals(arr[i])) {
                    stack.pop();
                } else {
                    stack.push(arr[i]);
                }
            }
        }
        Deque<String> mylist = new LinkedList<>();
        while (!stack.isEmpty()) {
            mylist.addFirst(stack.pop());
        }
        mylist.stream().forEach(element -> System.out.println(element + "\t"));
    }
}
