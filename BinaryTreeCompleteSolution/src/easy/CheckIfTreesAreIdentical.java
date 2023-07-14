package easy;

import base.BinaryTree;
import base.BinaryTreeBuilder;

public class CheckIfTreesAreIdentical {
    public static void main(String[] args) {
        BinaryTree node1 = BinaryTreeBuilder.buildBasicBinaryTree();

        BinaryTree node2 = BinaryTreeBuilder.buildBasicBinaryTree();
        System.out.print(checkIfTreesAreIdentical(node1, node2));
    }

    public static boolean checkIfTreesAreIdentical(BinaryTree node1, BinaryTree node2) {
        if(node1==null && node2==null)
            return true;
        if(node1==null || node2==null){
            return false;
        }
        return(node1.data==node2.data) && checkIfTreesAreIdentical(node1.left, node2.left) && checkIfTreesAreIdentical(node1.right, node2.right);
    }

}
