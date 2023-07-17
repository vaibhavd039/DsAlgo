package medium;

import base.BST;
import base.BSTBuilder;
import base.BSTIterator;

public class FixSwappedNodes {
    static BST prevNode, midNode, firstNode, lastNode;

    public static void main(String[] args) {
        BST node = BSTBuilder.buildSampleBST();
        node.left.left.data = 19;
        node.right.right.data = 2;

        node = correctTree(node);
        BSTIterator.inOrder(node);
    }


    public static void fixTheBST(BST node) {
        if (node == null)
            return;
        fixTheBST(node.left);
        if (prevNode != null && node.data < prevNode.data) {
            if (firstNode == null) {
                firstNode = prevNode;
                midNode = node;
            } else {
                lastNode = node;
            }
        } else {
            prevNode = node;
        }
        fixTheBST(node.right);
    }

    public static BST correctTree(BST node) {
        fixTheBST(node);
        if (firstNode != null && lastNode != null) {
            int temp = firstNode.data;
            firstNode.data = lastNode.data;
            lastNode.data = temp;
        } else {
            int temp = firstNode.data;
            firstNode.data = midNode.data;
            midNode.data = temp;
        }
        return node;
    }


}
