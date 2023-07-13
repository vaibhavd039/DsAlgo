package traversal;

import base.BinaryTree;
import base.BinaryTreeBuilder;
import base.BinaryTreeIterator;

public class NthNodeInOrder {
    static int counter= 1;
    public static void main(String [] args){
        BinaryTree root = BinaryTreeBuilder.buildBasicBinaryTree();
        BinaryTreeIterator.inOrderTraversal(root);
        System.out.print("\n");
        getNthNode(root, 5);

    }

    public static void getNthNode(BinaryTree node, int n){
        if(node==null)
            return;
        getNthNode(node.left, n);
        if(counter==n){
            System.out.println("nth node is "+ node.data);
            counter++;
            return;
        } else {
            counter++;
        }
        getNthNode(node.right, n);
    }
}
