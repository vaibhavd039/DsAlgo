package easy;

import base.BinaryTree;
import base.BinaryTreeBuilder;

public class SubtreeWIthGIvenSum {

    static boolean subTreeExists = false;

    public static void main(String[] args) {
        BinaryTree node = BinaryTreeBuilder.buildBasicBinaryTree();
        getSum(node, 12);
        System.out.print(subTreeExists);

    }

    public static int getSum(BinaryTree node, int sum) {
        if (node == null)
            return 0;
        if (getSum(node.left, sum) + getSum(node.right, sum) == sum) {
            subTreeExists = true;
        }
        return getSum(node.left, sum) + getSum(node.right, sum) + node.data;
    }
}
