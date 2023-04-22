package traversal_rev;

import intro.BinaryTree;
import intro.BinaryTreeBuilder;
import intro.BinaryTreeIterator;

import java.awt.desktop.SystemEventListener;
import java.util.List;

public class NthNodeInOrder {
    static int count=0;
    public static void main(String [] args){
        BinaryTree node = BinaryTreeBuilder.buildBinaryTree(List.of(1,2,3,4,5,6,7,8,9));
        BinaryTreeIterator.inorderTraversal(node);
        System.out.println("");
        nthNodeInorder(node,2);
    }

    public static void nthNodeInorder(BinaryTree node, int n){
        if(node==null)
            return;
        if(count<n){
            nthNodeInorder(node.left, n);
            count++;
            if(count==n){
               System.out.println(node.data);
            }
            nthNodeInorder(node.right, n);
        }

    }
}
