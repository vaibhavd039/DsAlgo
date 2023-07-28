package medium;

import java.util.Stack;

class Element {
    int data;
    int index;

    Element(int data, int index) {
        this.data = data;
        this.index = index;
    }
}

public class NextGreaterElement {
    public static void main(String[] args) {
        int[] arr = {100, 80, 60, 75, 90, 110, 96, 100};
        int[] ans = nextGreaterElement(arr);
        for (int i = 0; i < ans.length; i++) {
            System.out.println(arr[i] + " " + ans[i]);
        }
    }

    public static int[] nextGreaterElement(int[] arr) {
        int[] ans = new int[arr.length];
        Stack<Element> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && stack.peek().data < arr[i]) {
                Element temp = stack.pop();
                ans[temp.index] = arr[i];
            }
            stack.push(new Element(arr[i], i));
        }
        while (!stack.isEmpty()) {
            Element temp = stack.pop();
            ans[temp.index] = -1;
        }
        return ans;
    }
}
