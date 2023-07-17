package medium;

import base.BST;
import base.BSTBuilder;
import base.BSTIterator;

public class BSTToTreeWithSumOfSmallerKeys {
    static BST prevNode;

    public static void main(String[] args) {
        BST node = BSTBuilder.buildSampleBST();
        modifyTree(node);
        BSTIterator.inOrder(node);
    }

    public static void modifyTree(BST node) {
        if (node == null)
            return;
        modifyTree(node.left);
        if (prevNode == null) {
            prevNode = node;
        } else {
            node.data = prevNode.data + node.data;
            prevNode = node;
        }
        modifyTree(node.right);
    }
}
