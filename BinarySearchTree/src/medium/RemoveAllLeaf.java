package medium;

import base.BST;
import base.BSTBuilder;
import base.BSTIterator;

//We have given a binary search tree and we want to delete the leaf nodes from the binary search tree.
public class RemoveAllLeaf {
    public static void main(String[] args) {
        BST node = BSTBuilder.buildSampleBST();
        removeLeafNode(node);
        BSTIterator.inOrder(node);
    }

    public static void removeLeafNode(BST node) {
        if(node==null)
            return;
        if(isLeafNode(node))
        {
            node=null;
        }
        if(node.left!=null){
            if(isLeafNode(node.left)){
                node.left=null;
            } else {
                removeLeafNode(node.left);
            }
        }
        if(node.right!=null){
            if(isLeafNode(node.right)){
                node.right=null;
            } else {
                removeLeafNode(node.right);
            }
        }
    }

    public static boolean isLeafNode(BST node) {
        return node.left == null && node.right == null;
    }


}
