package medium;

import intro.BinaryTree;
import intro.BinaryTreeBuilder;
import intro.BinaryTreeIterator;

import java.util.List;

class CustomBinaryTree{
    int data;
    CustomBinaryTree left, right, next;
    CustomBinaryTree(int data){
        this.data = data;
    }
}

public class PopulateInorderSuccesor {
    public static void main(String [] args){
        CustomBinaryTree root = new CustomBinaryTree(1);
        root.left =new CustomBinaryTree(2);
        root.right =new CustomBinaryTree(3);
        root.left.left =new CustomBinaryTree(4);
        root.left.right =new CustomBinaryTree(5);
        root.right.left =new CustomBinaryTree(4);
        root.right.right =new CustomBinaryTree(5);
        generateInOrderSuccessor(root);
        inOrderTraversal(root);
    }

    static CustomBinaryTree prev =null;

    public static void generateInOrderSuccessor(CustomBinaryTree node){
        if(node ==null)
            return;
        generateInOrderSuccessor(node.left);
        if(prev==null){
            prev=node;
        } else{
            prev.next=node;
            prev=node;
        }
        generateInOrderSuccessor(node.right);

    }

    public static void inOrderTraversal(CustomBinaryTree node){
        if(node==null)
            return;
        inOrderTraversal(node.left);
        System.out.println(node.data+"\t"+(node.next!=null?node.next.data:"null"));
        inOrderTraversal(node.right);

    }

}
