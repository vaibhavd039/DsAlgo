package easy;

import base.BST;
import base.BSTBuilder;
import base.BSTIterator;

class Sum {
    public int sum;
}

public class AddAllGreaterValueToGivenNode {
    public static void main(String[] args) {
        BST node = BSTBuilder.buildSampleBST();
        Sum sum = new Sum();
        sum.sum = 0;
        modifyTree(node, sum);
        BSTIterator.levelOrder(node);
    }

    public static void modifyTree(BST node, Sum sum) {
        if (node == null)
            return;
        modifyTree(node.right, sum);
        sum.sum += sum.sum + node.data;
        modifyTree(node.left, sum);
    }
}
