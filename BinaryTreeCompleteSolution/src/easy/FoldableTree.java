package easy;

import base.BinaryTree;
import base.BinaryTreeBuilder;

public class FoldableTree {
    public static void main(String[] args) {
        BinaryTree node = BinaryTreeBuilder.buildBasicBinaryTree();

        System.out.print(isFoldable(node.left, node.right));
    }

    public static boolean isFoldable(BinaryTree node1, BinaryTree node2) {
        if (node1 == null && node2 == null)
            return true;
        if (node1 == null || node2 == null)
            return false;
        return isFoldable(node1.left, node2.right) && isFoldable(node1.right, node2.left);
    }
}
