package traversal;

import base.BinaryTree;
import base.BinaryTreeBuilder;
import base.BinaryTreeIterator;

//Given a binary tree and a node, we need to write a program to find inorder successor of this node.
//        Inorder Successor of a node in binary tree is the next node in Inorder traversal of the Binary Tree.
//        Inorder Successor is NULL for the last node in Inorder traversal.
public class InorderSuccsorOfNode {
    static BinaryTree last = null;

    public static void main(String[] args) {
        BinaryTree root = BinaryTreeBuilder.buildBasicBinaryTree();
        BinaryTreeIterator.inOrderTraversal(root);
        System.out.print("\n");
        printSuccessor(root, 11);
    }

    public static void printSuccessor(BinaryTree root, int x) {
        if (root == null)
            return;
        printSuccessor(root.right, x);
        if (root.data == x) {
            int succesor = last == null ? -1 : last.data;
            System.out.print(x + "\t successor was " + succesor);
            return;
        } else {
            last = root;
        }
        printSuccessor(root.left, x);

    }
}
