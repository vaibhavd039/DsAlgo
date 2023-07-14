package easy;

import base.BinaryTree;
import base.BinaryTreeBuilder;

class Height {
    int height;
}

public class DiameterOfTree {
    public static void main(String[] args) {
        BinaryTree node1 = BinaryTreeBuilder.buildBasicBinaryTree();
        Height height = new Height();
        System.out.print(computeDiameter(node1, height));
    }


    public static int computeDiameter(BinaryTree node, Height height) {
        if (node == null) {
            height.height = 0;
            return 0;
        }
        Height leftHeight = new Height();
        Height rightHeight = new Height();
        int leftDiameter = computeDiameter(node.left, leftHeight);
        int rightDiameter = computeDiameter(node.right, rightHeight);
        height.height = Math.max(leftHeight.height, rightHeight.height) + 1;
        return Math.max(Math.max(leftDiameter, rightDiameter), (leftHeight.height + rightHeight.height) + 1);
    }

}
