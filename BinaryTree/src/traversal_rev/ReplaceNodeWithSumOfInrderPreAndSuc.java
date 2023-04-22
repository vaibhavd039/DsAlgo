package traversal_rev;

import intro.BinaryTree;
import intro.BinaryTreeBuilder;
import intro.BinaryTreeIterator;

import java.util.List;

public class ReplaceNodeWithSumOfInrderPreAndSuc {
    public static void main(String [] args) {
        BinaryTree root = BinaryTreeBuilder.buildBinaryTree(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9));

        BinaryTreeIterator.inorderTraversal(root);
        System.out.println("\t");
        replaceNodeWithInOrderSuccessorAndPredecessor(root);
        BinaryTreeIterator.inorderTraversal(root);
    }

    static BinaryTree prev=null;
    static int prevData=0;
    public static void replaceNodeWithInOrderSuccessorAndPredecessor(BinaryTree node){
        if(node==null)
            return;
        replaceNodeWithInOrderSuccessorAndPredecessor(node.left);
        if(prev==null){
            prev=node;
        } else {
            int temp= prev.data;
            prev.data= prevData+node.data;
            prev=node;
            prevData=temp;
        }
        replaceNodeWithInOrderSuccessorAndPredecessor(node.right);
    }


}
