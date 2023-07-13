package traversal;

import base.BinaryTree;
import base.BinaryTreeBuilder;

//Density of Binary Tree = Size / Height

public class DensityOfBinaryTree {
    static int size = 0;

    public static void main(String[] args) {
        BinaryTree node = BinaryTreeBuilder.buildBasicBinaryTree();
        System.out.print(getDensity(node));
    }

    public static double getDensity(BinaryTree node) {
        int height = getHeight(node);
        return (double) size / height;
    }

    public static int getHeight(BinaryTree node) {
        if (node == null)
            return 0;
        int left = getHeight(node.left);
        int right = getHeight(node.right);
        size++;
        return Math.max(left, right) + 1;
    }

}
