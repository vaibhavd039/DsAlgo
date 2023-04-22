package traversal_rev;

import intro.BinaryTree;
import intro.BinaryTreeBuilder;
import java.util.List;

public class MorisTraversal {
    public static void main(String [] args){
        BinaryTree root = BinaryTreeBuilder.buildBinaryTree(List.of(1,2,3,4,5,6,7,8,9));
        morisTraversal(root);
    }
    public static void morisTraversal(BinaryTree node){
        if(node==null)
            return;
        BinaryTree curr = node;
        while(curr!=null){
            if(curr.left==null){
                System.out.print(curr.data+"\t");
                curr=curr.right;
            } else {
                BinaryTree predecessor = curr.left;
                while(predecessor.right!=null && predecessor.right!=curr)
                    predecessor=predecessor.right;
                if(predecessor.right==null){
                    predecessor.right=curr;
                    curr=curr.left;
                }
                 else {
                     predecessor.right=null;
                    System.out.print(curr.data+"\t");
                    curr=curr.right;
                }
            }
        }
    }
}
