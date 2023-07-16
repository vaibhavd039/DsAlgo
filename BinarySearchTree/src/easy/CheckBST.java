package easy;

import base.BST;
import base.BSTBuilder;

public class CheckBST {
    static int MIN, MAX;

    public static void main(String[] args) {

        BST node = BSTBuilder.buildSampleBST();
        System.out.print(checkIfBST(node, Integer.MIN_VALUE, Integer.MAX_VALUE));
    }

    public static boolean checkIfBST(BST node, int min, int max) {
        if (node == null)
            return true;
        if (node.data < min || node.data > max) {
            return false;
        }
        return checkIfBST(node.left, min, node.data - 1) && checkIfBST(node.right, node.data + 1, max);
    }
}
