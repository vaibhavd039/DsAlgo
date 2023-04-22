package traversal_rev;

import intro.BinaryTree;
import intro.BinaryTreeBuilder;
import intro.BinaryTreeIterator;

import java.util.List;

public class PreOrderMorris {
    public static void main(String [] args){
        BinaryTree root = BinaryTreeBuilder.buildBinaryTree(List.of(1,2,3,4,5,6,7,8,9));
//        preOrderMorris(root);

        preOrderMorris(root);
    }

    public static void preOrderMorris(BinaryTree node){
        BinaryTree curr = node;
        BinaryTree predecessor = null;
        while(curr!=null){

            if(curr.left==null){
                System.out.print(curr.data+"\t");
                curr=curr.right;
            } else {
                predecessor= curr.left;
                while(predecessor.right!=null && predecessor.right!=curr){
                    predecessor=predecessor.right;
                }

                if(predecessor.right==curr) {
                    predecessor.right=null;
                    curr=curr.right;
                }

               else{
                    System.out.print(curr.data+"\t");
                    predecessor.right=curr;
                    curr=curr.left;
                }
            }

        }
    }
}
