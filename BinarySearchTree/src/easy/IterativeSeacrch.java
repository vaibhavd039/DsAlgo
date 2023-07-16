package easy;

import base.BST;
import base.BSTBuilder;

public class IterativeSeacrch {
    public static void main(String[] args) {
        BST node = BSTBuilder.buildSampleBST();
        System.out.print(searchElement(node, 18));

    }

    public static int searchElement(BST node, int data) {
        if (node == null)
            return -1;

        while (node != null) {
            if (node.data == data) {
                return data;
            } else if (node.data > data) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return -1;

    }
}
