package hard;

//Given two binary trees. We need to merge them into a new binary tree. The merge rule is that if two nodes overlap,
// then sum node values up as the new value of the merged node. Otherwise, the non-null node will be used as the node
// of new tree.

import base.BinaryTree;
import base.BinaryTreeBuilder;
import base.BinaryTreeIterator;

import java.util.List;

public class MergeTwoBinaryTree {
    public static void main(String[] args) {
        BinaryTree node = BinaryTreeBuilder.buildBasicBinaryTree();
        BinaryTree node2 = BinaryTreeBuilder.buildBinaryTree(List.of(1,2,3));
        BinaryTree merged = megretree(node, node2);
        BinaryTreeIterator.levelOrderTraversal(merged);
    }

    public static BinaryTree megretree(BinaryTree node1, BinaryTree node2) {
        if (node1 == null && node2 == null) {
            return null;
        }
        int node1Data = (node1 == null ? 0 : node1.data);
        int node2Data = (node2 == null ? 0 : node2.data);
        BinaryTree node = new BinaryTree(node1Data + node2Data);
        BinaryTree node1Left = node1 == null ? null : node1.left;
        BinaryTree node2Left = node2 == null ? null : node2.left;
        BinaryTree node1Right = node1 == null ? null : node1.right;
        BinaryTree node2Right = node2 == null ? null : node2.right;
        node.left = megretree(node1Left, node2Left);
        node.right = megretree(node1Right, node2Right);
        return node;
    }
}
