package traversal;

import intro.BinaryTree;
import intro.BinaryTreeBuilder;
import intro.BinaryTreeIterator;

import java.util.List;

public class PopulateInorderPredecessor {
    public static void main(String [] args){
        BinaryTree root = BinaryTreeBuilder.buildBinaryTree(List.of(1,2,3,4,5,6,7,8,9));
        BinaryTreeIterator.inorderTraversal(root);
        System.out.print("\n");
        printInordeerSuccessor(root);
    }
    static BinaryTree prev=null;
    public static void printInordeerSuccessor(BinaryTree root){
        if(root==null)
            return;
        printInordeerSuccessor(root.left);
            if(prev==null){
                prev=root;
                System.out.println(("No in order successor for: "+root.data));
            } else {
                System.out.println("Node: "+root.data+", InOrderSuccesor:"+prev.data);
                prev=root;
            }
        printInordeerSuccessor(root.right);
    }
}
