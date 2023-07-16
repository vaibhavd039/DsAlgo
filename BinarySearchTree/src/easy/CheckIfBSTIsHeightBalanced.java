package easy;

import base.BST;
import base.BSTBuilder;

public class CheckIfBSTIsHeightBalanced {
    static boolean isBalanced = true;

    public static void main(String[] args) {
        BST node = BSTBuilder.buildSampleBST();
        checkIfHeightBalanced(node);
        System.out.print(isBalanced);

    }

    public static int checkIfHeightBalanced(BST node) {
        if (node == null)
            return 0;
        int leftHeight = checkIfHeightBalanced(node.left);
        int rightHeight = checkIfHeightBalanced(node.right);
        if (Math.abs(leftHeight - rightHeight) > 1) {
            isBalanced = false;
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
