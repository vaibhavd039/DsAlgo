package medium;

import intro.BinaryTree;
import intro.BinaryTreeBuilder;
import intro.BinaryTreeIterator;

import java.util.List;

public class FlipBinaryTreeMed {
    public static void main(String [] args) {
        BinaryTree node = BinaryTreeBuilder.buildBinaryTree(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9));
        node = flipBinaryTree(node);
        BinaryTreeIterator.levelOrderTraversal(node);
    }

    public static BinaryTree flipBinaryTree(BinaryTree node){
        if(node==null)
            return null;
        BinaryTree left = flipBinaryTree(node.left);
        BinaryTree right = flipBinaryTree(node.right);
        node.left=right;
        node.right=left;
        return node;
    }
}
