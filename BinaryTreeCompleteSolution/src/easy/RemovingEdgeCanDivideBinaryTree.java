package easy;

import base.BinaryTree;
import base.BinaryTreeBuilder;

public class RemovingEdgeCanDivideBinaryTree {
    static boolean isPossible;

    public static void main(String[] args) {
        BinaryTree node = BinaryTreeBuilder.buildBasicBinaryTree();
        checkPossible(node);
        System.out.print(isPossible);
    }

    public static void checkPossible(BinaryTree node) {
        int size = getSize(node);
        checkRecord(node, size);
    }

    public static int getSize(BinaryTree node) {
        if (node == null)
            return 0;
        int left = getSize(node.left);
        int right = getSize(node.right);
        return left + right + 1;
    }



    public static int checkRecord(BinaryTree node, int size) {
        if (node == null)
            return 0;
        int current_size = checkRecord(node.left, size) + checkRecord(node.right, size) + 1;
        if (current_size ==size-current_size){
            isPossible=true;
        }
        return current_size;
    }
}
