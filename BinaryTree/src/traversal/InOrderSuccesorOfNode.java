package traversal;

import intro.BinaryTree;
import intro.BinaryTreeBuilder;
import intro.BinaryTreeIterator;

import java.util.List;

public class InOrderSuccesorOfNode {
    public static void main(String [] args){
        BinaryTree root = BinaryTreeBuilder.buildBinaryTree(List.of(1,2,3,4,5,6,7,8,9));
        BinaryTreeIterator.inorderTraversal(root);
        System.out.print("\n");
        printInOrderSuccessorofNode(root, 2);
    }

    static BinaryTree prev;

    public static void printInOrderSuccessorofNode(BinaryTree node, int data){
        if(node==null)
            return;
        printInOrderSuccessorofNode(node.left,data);
        if(prev==null){
            prev=node;
        } else {
            if(prev.data==data){
                System.out.print("Next Node for node: "+prev.data+", is nextNode: "+node.data);
                prev=node;
                return;
            } else {
                prev =node;
            }
        }
        printInOrderSuccessorofNode(node.right,data);
    }
}
