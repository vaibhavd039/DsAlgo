package easy_rev;

//Write a function that returns true if the given Binary Tree is SumTree else false.
// A SumTree is a Binary Tree where the value of a node is equal
// to the sum of the nodes present in its left subtree and right subtree.

import intro.BinaryTree;
import intro.BinaryTreeBuilder;

import java.util.List;

public class CheckIfSumTree {
    static boolean isSumTree = false;

    public static void main(String[] args) {
        BinaryTree node = BinaryTreeBuilder.buildBinaryTree(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15
                , 16, 17, 18, 19, 20));
        System.out.print(checkIfSumTree(node));
    }

    public static int checkIfSumTree(BinaryTree node) {
        if (node == null)
            return 0;
        int ls = checkIfSumTree(node.left);
        int rs = checkIfSumTree(node.right);
        if (ls == -1 || rs == -1)
            return -1;
        if (node.data != ls + rs) {
            if (node.left == null && node.right == null)
                return node.data;
            return -1;
        } else {
            return node.data;
        }
    }


}
