package traversal_rev;

import intro.BinaryTree;
import intro.BinaryTreeBuilder;

import java.util.List;

public class TraversalBase {
    public static void main(String [] args){
        BinaryTree root = BinaryTreeBuilder.buildBinaryTree(List.of(1,2,3,4,5,6,7,8,9));
        inorder(root);
        System.out.println("\t");
        preOrder(root);
        System.out.println("\t");
        postOrder(root);
    }
    public static void inorder(BinaryTree node){
        if(node==null){
            return;
        }
        inorder(node.left);
        System.out.print(node.data+"\t");
        inorder(node.right);
    }

    public static void preOrder(BinaryTree node){
        if(node==null)
            return;
        System.out.print(node.data+"\t");
        preOrder(node.left);
        preOrder(node.right);
    }

    public static void postOrder(BinaryTree node){
        if(node==null)
            return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.data+"\t");
    }
}
