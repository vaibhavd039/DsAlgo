package traversal;

import intro.BinaryTree;
import intro.BinaryTreeBuilder;
import intro.BinaryTreeIterator;

import java.util.List;

class CustomerBinaryTree {
    int data;
    CustomerBinaryTree next;
    CustomerBinaryTree left;
    CustomerBinaryTree right;

    CustomerBinaryTree(BinaryTree node){
        this.data = node.data;
    }
    CustomerBinaryTree(int node){
        this.data = node;
    }
}
public class InorderSuccessor {
    public static void main(String [] args){
        CustomerBinaryTree newroot= new CustomerBinaryTree(1);
        newroot.left = new CustomerBinaryTree(2);
        newroot.right = new CustomerBinaryTree(3);
        newroot.left.left = new CustomerBinaryTree(4);
        newroot.left.right = new CustomerBinaryTree(5);
        newroot.right.left = new CustomerBinaryTree(6);
        newroot.right.right = new CustomerBinaryTree(7);
        inOrderTraversal(newroot);
        System.out.print("\n");
        createSuccesorNode(newroot);
        printInorderSuccessor(newroot);
    }

    public static void inOrderTraversal(CustomerBinaryTree root){
        if(root==null)
            return;
        inOrderTraversal(root.left);
        System.out.print(root.data+"\t");
        inOrderTraversal(root.right);
    }
    public static void printInorderSuccessor(CustomerBinaryTree node){
    if(node==null)
        return;
    printInorderSuccessor(node.left);
    System.out.println("node: "+node.data+" next node: "+ (node.next!=null?node.next.data:0));
    printInorderSuccessor(node.right);

    }

    public static CustomerBinaryTree nextNode=null;
    public static void createSuccesorNode(CustomerBinaryTree node){
        if(node==null){
            return;
        }
        createSuccesorNode(node.right);
        node.next=nextNode;
        nextNode = node;
        createSuccesorNode(node.left);
    }
}
