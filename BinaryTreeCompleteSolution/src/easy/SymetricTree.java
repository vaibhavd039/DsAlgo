package easy;

import base.BinaryTree;
import base.BinaryTreeBuilder;

import java.util.Stack;

public class SymetricTree {
    public static void main(String[] args) {
            BinaryTree node = BinaryTreeBuilder.buildBasicBinaryTree();
            System.out.print(checkSymetric(node));
    }

    public static boolean checkSymetric(BinaryTree node) {
        if (node == null)
            return true;
        Stack<BinaryTree> stack = new Stack<>();
        stack.push(node.left);
        stack.push(node.right);
        while (!stack.isEmpty()) {
            BinaryTree node1 = stack.pop();
            BinaryTree node2 = stack.pop();
            if (node1 == null && node2 == null) {
                continue;
            }
            if (node1 == null || node == null) {
                return false;
            }

            if (node1.data != node2.data) {
                return false;
            }
            stack.push(node1.left);
            stack.push(node2.right);
            stack.push(node1.right);
            stack.push(node2.left);
        }
        return true;
    }
}
