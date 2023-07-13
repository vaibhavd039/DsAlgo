package traversal;

import base.BinaryTree;
import base.BinaryTreeBuilder;

public class MorrisPreOrder {
    public static void main(String[] args) {
        BinaryTree node = BinaryTreeBuilder.buildBasicBinaryTree();
        morrisPreOrder(node);
    }

    public static void morrisPreOrder(BinaryTree node) {
        BinaryTree curr = null;
        if (node == null)
            return;
        while (node != null) {
            if (node.left != null) {
                curr = node.left;
                while (curr.right != null && curr.right != node) {
                    curr = curr.right;
                }
                if (curr.right == null) {
                    System.out.print(node.data + "\t");
                    curr.right = node;
                    node = node.left;
                } else {
                    curr.right = null;
                    node = node.right;
                }
            } else {
                System.out.print(node.data + "\t");
                node = node.right;
            }
        }
    }
}
