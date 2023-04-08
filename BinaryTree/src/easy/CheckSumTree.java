package easy;

import intro.BinaryTree;
import intro.BinaryTreeBuilder;
import intro.BinaryTreeIterator;

import java.util.List;

//Write a function that returns true if the given Binary Tree is SumTree else false.
//        A SumTree is a Binary Tree where the value of a node is equal to the sum of the nodes present in its left subtree and right subtree.
public class CheckSumTree {
    static boolean isSumTree=false;
    public static void main(String [] args){
        BinaryTree node = BinaryTreeBuilder.buildBinaryTree(List.of(26,10,3,4,6,3));
        BinaryTreeIterator.levelOrderTraversal(node);
       int x= checkifSumTree(node);
       if(x!=-1){
           isSumTree=true;
       }
        System.out.print(isSumTree);
    }

    public static int checkifSumTree(BinaryTree node){
        if(node==null)
            return 0;
        int sumLeft = checkifSumTree(node.left);
        if(sumLeft==-1)
            return -1;
        int sumRight = checkifSumTree(node.right);
        if(sumRight==-1)
            return -1;
        if(node.data==sumLeft+sumRight || (node.left==null && node.right==null)){
           return sumLeft+sumRight+node.data;
        }
        else
            return -1;
    }
}
