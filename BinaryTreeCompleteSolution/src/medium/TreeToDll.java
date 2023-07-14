package medium;

import base.BinaryTree;
import base.BinaryTreeBuilder;


public class TreeToDll {
    static BinaryTree prevNode;

    public static void main(String[] args) {
        BinaryTree node = BinaryTreeBuilder.buildBasicBinaryTree();
        BinaryTree list = createDLL(node);
        while (list.left != null) {
            list = list.left;
        }
        while (list.right != null) {
            System.out.print(list.data + "\t");
            list = list.right;
        }
    }

    public static BinaryTree createDLL(BinaryTree node) {
        if (node == null) {
            return null;
        }
        if(node.left!=null) {
            BinaryTree left = createDLL(node.left);
            while(left.right!=null){
                left=left.right;
            }
            left.right=node;
            node.left=left;
        }
        if(node.right!=null){
            BinaryTree right = createDLL(node.right);
            while(right.left!=null){
                right=right.left;
            }
            right.left=node;
            node.right=right;
        }

        return node;
    }
}
