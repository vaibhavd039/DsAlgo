package easy;

import intro.BinaryTree;
import intro.BinaryTreeBuilder;

import java.util.List;

public class CheckSymetricTree {
    public static void main(String [] args){
        BinaryTree bt1 = BinaryTreeBuilder.buildBinaryTree(List.of(1,2,3,4,5,6,7,8,9));
        System.out.print(checkIfMirror(bt1.left, bt1.right));
    }

    public static boolean checkIfMirror(BinaryTree node1 , BinaryTree node2){
        if(node1==null && node2==null)
            return true;
        if(node1!=null && node2!=null){
            return (node1.data==node2.data) && checkIfMirror(node1.left, node2.right) && checkIfMirror(node1.right, node2.left);
        }
        return false;
    }
}
