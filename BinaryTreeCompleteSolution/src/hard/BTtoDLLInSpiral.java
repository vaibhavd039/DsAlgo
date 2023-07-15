package hard;

import base.BinaryTree;
import base.BinaryTreeBuilder;

import java.util.Stack;

class DLL {
    int data;
    DLL next;
    DLL prev;

    DLL(int data) {
        this.data = data;
    }
}

public class BTtoDLLInSpiral {

    public static void main(String[] args) {
        BinaryTree node = BinaryTreeBuilder.buildBasicBinaryTree();
        DLL head = createDLL(node);
        while (head.next != null) {

            System.out.print(head.data + "\t");
            head = head.next;
        }
    }

    public static DLL createDLL(BinaryTree node) {
        if (node == null)
            return null;
        Stack<BinaryTree> stack1 = new Stack<>();
        Stack<BinaryTree> stack2 = new Stack<>();
        stack1.push(node);
        DLL prev = null;
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                BinaryTree temp = stack1.pop();
                if (temp == null)
                    continue;
                DLL dll = new DLL(temp.data);
                if (prev == null) {
                    prev = dll;
                } else {
                    prev.next = dll;
                    dll.prev = prev;
                    prev = dll;
                }
                stack2.push(temp.left);
                stack2.push(temp.right);
            }

            while (!stack2.isEmpty()) {
                BinaryTree temp = stack2.pop();
                if (temp == null)
                    continue;
                DLL dll = new DLL(temp.data);
                if (prev == null) {
                    prev = dll;
                } else {
                    prev.next = dll;
                    dll.prev = prev;
                    prev = dll;
                }
                stack1.push(temp.right);
                stack1.push(temp.left);

            }
        }
        while (prev.prev != null) {
            prev = prev.prev;
        }
        return prev;
    }
}
