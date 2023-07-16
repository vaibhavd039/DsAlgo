package hard;

import base.BinaryTree;
import base.BinaryTreeBuilder;

public class SumOfAllNumbersFormedFromRootToLeaf {
    public static void main(String[] args) {
        BinaryTree node = BinaryTreeBuilder.buildBasicBinaryTree();
        int data = getSumOfNumberFormedFromRootToleaf(node, 0);
        System.out.print(data);
    }

    public static int getSumOfNumberFormedFromRootToleaf(BinaryTree node, int value) {
        if (node == null)
            return 0;
        value = value * 10 + node.data;
        if (node.left == null && node.right == null) {
            return value;
        }
        return  getSumOfNumberFormedFromRootToleaf(node.left,value) + getSumOfNumberFormedFromRootToleaf(node.right, value);
    }
}
