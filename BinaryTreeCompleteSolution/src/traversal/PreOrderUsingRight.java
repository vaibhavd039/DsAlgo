package traversal;
//Modify a binary tree to get preorder traversal using right pointers only

import base.BinaryTree;
import base.BinaryTreeBuilder;

public class PreOrderUsingRight {
    public static void main(String[] args) {
        BinaryTree node = BinaryTreeBuilder.buildBasicBinaryTree();
        modifyTree(node);
        iterateTree(node);
    }

    public static void modifyTree(BinaryTree node) {
        BinaryTree curr;
        if (node == null) {
            return;
        }
        while (node != null) {
            if (node.left != null) {
                curr = node.left;
                while (curr.right != null && curr.right != node) {
                    curr = curr.right;
                }

                if (curr.right == null) {
                    curr.right = node;
                    node = node.left;
                }
                if (curr.right == node) {
                    node = node.right;
                }
            } else {
                node = node.right;
            }
        }
    }

    public static void iterateTree(BinaryTree node) {
        if(node==null)
            return;
        while(node.left!=null){
            node=node.left;
        }

        while(node.right!=null){
            System.out.print(node.data+"\t");
            node = node.right;
        }
    }

}
