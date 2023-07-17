package medium;

import base.BST;
import base.BSTBuilder;
import base.BSTIterator;

public class ConvertBSTTOGreterSumtree {
    static BST prevNode = null;

    public static void main(String[] args) {
        BST node = BSTBuilder.buildSampleBST();
        createGreaterSumTree(node);
        BSTIterator.inOrder(node);
    }

    public static void createGreaterSumTree(BST node) {
        if (node == null)
            return;
        createGreaterSumTree(node.right);
        if (prevNode == null) {
            prevNode = node;
        } else {
            node.data = prevNode.data + node.data;
            prevNode = node;
        }
        createGreaterSumTree(node.left);

    }


}
