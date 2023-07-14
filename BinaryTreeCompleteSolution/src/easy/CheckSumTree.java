package easy;

//Check if a given Binary Tree is SumTree
// SumTree is a Binary Tree where the value of a node is equal to the sum of the nodes present in its left subtree
// and right subtree.

import base.BinaryTree;
import base.BinaryTreeBuilder;

public class CheckSumTree {

    public static void main(String[] args) {
        BinaryTree node = BinaryTreeBuilder.buildBasicBinaryTree();
        System.out.print(isSumTree(node));

    }

    public static boolean isSumTree(BinaryTree node) {
        if (node == null) return true; boolean left = isSumTree(node.left); boolean right = isSumTree(node.right);
        if (left && right) {
            int leftData = node.left == null ? 0 : node.left.data;
            int rightData = node.right == null ? 0 : node.right.data;
            if (node.data == leftData + rightData) {
                node.data = leftData + rightData + node.data; return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}
