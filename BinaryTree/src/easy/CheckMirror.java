package easy;

import intro.BinaryTree;
import intro.BinaryTreeBuilder;

import java.util.List;

public class CheckMirror {
    public static void main(String [] args){
        BinaryTree node1= BinaryTreeBuilder.buildBinaryTree(List.of(1,3,2,7,6,5,4));

        BinaryTree node2= BinaryTreeBuilder.buildBinaryTree(List.of(1,2,3,4,5,6,7));
        System.out.print(checkMirror(node1,node2));
    }

    public static boolean checkMirror(BinaryTree node1, BinaryTree node2){
        if(node1==null && node2==null)
            return true;
        if(node1==null || node2==null)
            return false;
      return   node1.data==node2.data && checkMirror(node1.left, node2.right) && checkMirror(node1.right, node2.left);
    }
}
