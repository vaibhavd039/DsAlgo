package medium;


import base.BinaryTree;
import base.BinaryTreeBuilder;
import base.BinaryTreeIterator;

import java.util.List;

//Rotate BinaryTree
////the leftmost node becomes the root
//
// its parent becomes its right child
//         right sibling becomes its left child
public class FlipBinaryTree {
    public static void main(String[] args) {
        BinaryTree node = BinaryTreeBuilder.buildBinaryTree(List.of(1,2,3,4,5,6,7,8,9));
        BinaryTreeIterator.levelOrderTraversal(node);
        System.out.print("\n");
        node = flipTree(node);
        BinaryTreeIterator.levelOrderTraversal(node);
    }

    public static BinaryTree flipTree(BinaryTree node) {
        if (node == null)
            return null;
        if (node.left == null && node.right == null) {
            return node;
        }
        BinaryTree flipped = flipTree(node.left);
        node.left.left = node.right;
        node.left.right = node;
        node.left = node.right = null;
        return flipped;
    }
}
