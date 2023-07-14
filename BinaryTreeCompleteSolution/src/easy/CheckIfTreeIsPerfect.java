package easy;

import base.BinaryTree;
import base.BinaryTreeBuilder;

import java.util.List;

public class CheckIfTreeIsPerfect {
    public static void main(String[] args) {
        BinaryTree root = BinaryTreeBuilder.buildBinaryTree(List.of(1, 2, 3, 4, 5, 6, 7, 8));
        int height = findDepthOfTree(root);
        System.out.print(checkIfPerfect(root, height, 1));
    }

    public static boolean checkIfPerfect(BinaryTree node, int height, int level) {
        if (isLeaf(node)) {
            return level == height;
        }
        if (node.left != null && node.right != null) {
            level++;
            return checkIfPerfect(node.left, height, level) && checkIfPerfect(node.right, height, level);
        } else {
            return false;
        }

    }

    public static boolean isLeaf(BinaryTree node) {
        return node.left == null && node.right == null;
    }


    public static int findDepthOfTree(BinaryTree node) {
        if (node == null)
            return 0;
        int left = findDepthOfTree(node.left);
        int right = findDepthOfTree(node.right);
        return Math.max(left, right) + 1;
    }
}
