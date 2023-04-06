package traversal;

import intro.BinaryTree;
import intro.BinaryTreeBuilder;

import java.util.List;

//Using Morris Traversal, we can traverse the tree without using stack and recursion. The algorithm for Preorder is almost similar to Morris traversal for Inorder.
public class MorrisTraversalPreOrder {
    public static void main(String [] args){
        BinaryTree node = BinaryTreeBuilder.buildBinaryTree(List.of(1,2,3,4,5,6,7,8,9));
        morrisPreOrder(node);
    }

    public static void morrisPreOrder(BinaryTree node) {
        while (node != null) {
            // If left child is null, print the current node data. Move to
            // right child.
            if (node.left == null) {
                System.out.print(node.data + "\t");
                node = node.right;
            } else {
                //find inorder predecrssor
                BinaryTree current = node.left;
                while (current.right != null && current.right != node) {
                    current = current.right;
                }
                if (current.right == node) {
                    current.right = null;
                    node = node.right;
                } else {
                    System.out.print(node.data + "\t");
                    current.right = node;
                    node = node.left;
                }
            }
        }
    }

}
