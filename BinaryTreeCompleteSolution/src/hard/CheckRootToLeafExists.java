package hard;

import base.BinaryTree;
import base.BinaryTreeBuilder;

public class CheckRootToLeafExists {
    public static void main(String[] args) {
        BinaryTree node = BinaryTreeBuilder.buildBasicBinaryTree();
        int[] arr = {1, 2, 4, 8, 18};
        System.out.print(doesPathExists(node, arr, arr.length, 0));
    }

    public static boolean doesPathExists(BinaryTree node, int[] arr, int n, int index) {
        if (node == null || index == n) {
            return false;
        }

        if (node.left == null && node.right == null) {
            return (node.data == arr[index] && (index == n - 1));
        }
        return (index < n) && (node.data == arr[index]) && (doesPathExists(node.left, arr, n, index + 1) || doesPathExists(node.left, arr, n, index + 1));
    }
}
