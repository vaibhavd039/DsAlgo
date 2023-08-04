package hard;

import java.util.Stack;

class BinaryTree {
    int data;
    BinaryTree left, right;

    BinaryTree(int data) {
        this.data = data;
    }

}

public class PostOrder {
    public static void main(String[] rgs) {
        BinaryTree node = new BinaryTree(1);
        node.left = new BinaryTree(2);
        node.right = new BinaryTree(3);
        node.left.left = new BinaryTree(4);
        node.left.right = new BinaryTree(5);
        node.right.left = new BinaryTree(6);
        node.right.right = new BinaryTree(7);
        postOrder(node);
    }

    public static void postOrder(BinaryTree node) {
        if (node == null)
            return;
        Stack<BinaryTree> stack = new Stack<>();
        while (true) {
            while (node != null) {
                stack.push(node);
                stack.push(node);
                node = node.left;
            }

            if (stack.isEmpty())
                return;
            node = stack.pop();
            if (!stack.isEmpty() && stack.peek() == node) {
                node = node.right;
            } else {
                System.out.print(node.data + "\t");
                node=null;
            }
        }
    }
}
