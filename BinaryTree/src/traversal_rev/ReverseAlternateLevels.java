package traversal_rev;
//Reverse alternate levels of a perfect binary tree

import intro.BinaryTree;
import intro.BinaryTreeBuilder;
import intro.BinaryTreeIterator;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class ReverseAlternateLevels {
    static  boolean isOddLevel=true;
    public static void main (String [] args){
        BinaryTree root = BinaryTreeBuilder.buildBinaryTree(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9,10,11,12,13,14,15));
        BinaryTreeIterator.levelOrderTraversal(root);
        System.out.println("");
        reverseAlternateLevels(root);
        BinaryTreeIterator.levelOrderTraversal(root);
        System.out.println("");

    }

    public static void  reverseAlternateLevels(BinaryTree node){
        if(node==null)
            return;

        Queue<BinaryTree> queue = new LinkedList<>();
        queue.add(node.left);
        queue.add(node.right);

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i =0;i<size;i+=2){
                BinaryTree temp1= queue.poll();
                BinaryTree temp2= queue.poll();
                if(isOddLevel) {
                    swapData(temp1, temp2);
                }
                if(temp1.left!=null){
                    queue.add(temp1.left);
                    queue.add(temp2.right);
                    queue.add(temp1.right);
                    queue.add(temp2.left);
                }
            }
            isOddLevel=!isOddLevel;
        }
    }

    public static  void swapData(BinaryTree node1, BinaryTree node2){
        int data = node1.data;
        node1.data= node2.data;
        node2.data= data;
    }

}
