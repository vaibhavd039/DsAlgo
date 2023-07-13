package traversal;

import base.BinaryTree;
import base.BinaryTreeBuilder;
import base.BinaryTreeIterator;

import java.util.Stack;

public class InOrderWithoutRecursion {
    public static void main(String[] argss) {
        BinaryTree root = BinaryTreeBuilder.buildBasicBinaryTree();
        BinaryTreeIterator.inOrderTraversal(root);
        System.out.print("\n");
        inOrderWithoutRecursion(root);

    }

    public static void inOrderWithoutRecursion(BinaryTree node) {
        BinaryTree curr = node;
        Stack<BinaryTree> stack = new Stack<>();
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            if (curr == null) {
                curr = stack.pop();
                System.out.print(curr.data + "\t");
                curr = curr.right;
            }
        }
    }
}
