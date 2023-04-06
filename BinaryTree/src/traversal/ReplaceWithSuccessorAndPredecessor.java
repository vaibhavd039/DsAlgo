package traversal;

import intro.BinaryTree;
import intro.BinaryTreeBuilder;
import intro.BinaryTreeIterator;

import java.util.List;

public class ReplaceWithSuccessorAndPredecessor {
    public static void main(String [] args){
        BinaryTree root = BinaryTreeBuilder.buildBinaryTree(List.of(1,2,3,4,5,6,7,8,9));
        BinaryTreeIterator.inorderTraversal(root);
        System.out.print("\n");
        replaceWithSuccessorAndPredecessor(root);
        BinaryTreeIterator.inorderTraversal(root);
    }

    static  BinaryTree prev=null;
    static int preVal =0;
    public static void replaceWithSuccessorAndPredecessor(BinaryTree node){
        if(node==null)
            return;
        replaceWithSuccessorAndPredecessor(node.left);
        if(prev==null){
            prev=node;
            preVal=0;
        } else {
            int temp = prev.data;
            prev.data= node.data+preVal;
            preVal=temp;
            prev=node;
        }
        replaceWithSuccessorAndPredecessor(node.right);
    }
}
