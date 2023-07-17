package medium;

//Given an array of N elements and two integers A, B which belong to the given array.
//        Create a Binary Search Tree by inserting elements from arr[0] to arr[n-1].
//        The task is to find the maximum element in the path from A to B.

import base.BST;
import base.BSTBuilder;

public class MaxElementBetweenTwoNodes {
    public static void main(String[] args) {
        BST node = BSTBuilder.buildSampleBST();
        BST lca = getLCA(node, 1, 16);
        int max1 = getMax(lca, 1);
        int max2 = getMax(lca, 16);
        System.out.print(Math.max(max1, max2));
    }

    public static BST getLCA(BST node, int a, int b) {
        if (node == null)
            return null;
        if (node.data > a && node.data > b) {
            return getLCA(node.left, a, b);
        } else if (node.data < a && node.data < b) {
            return getLCA(node.left, a, b);
        } else {
            return node;
        }
    }


    public static int getMax(BST node, int a) {
        int max = Integer.MIN_VALUE;
        while (node.data != a) {
            max = Math.max(max, node.data);
            if (node.data > a) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return max;
    }
}
