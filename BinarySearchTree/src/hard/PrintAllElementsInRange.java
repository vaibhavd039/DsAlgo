package hard;

import base.BST;
import base.BinaryTreeToBSTBuilder;

public class PrintAllElementsInRange {
    public static void main(String[] args) {
        BST node = BinaryTreeToBSTBuilder.buildSamplerBST();
        printinRange(node, 3,18);

    }

    public static void printinRange(BST node, int min, int max) {
        if (node == null)
            return;
        while (node != null) {
            if (node.left != null) {
                BST curr = node.left;
                while (curr.right != null && curr.right != node) {
                    curr = curr.right;
                }
                if (curr.right == null) {
                    curr.right = node;
                    node = node.left;
                } else if (curr.right == node) {
                    curr.right = null;
                    if (node.data >= min && node.data <= max) {
                        System.out.print(node.data+"\t");
                    }
                    node = node.right;
                }
            } else {
                if (node.data >= min && node.data <= max) {
                    System.out.print(node.data+"\t");
                }
                node = node.right;

            }
        }
    }

}
