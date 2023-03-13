package easy;

import intro.BinaryTree;
import intro.BinaryTreeBuilder;

import java.util.List;

public class HeighOfBinaryTree {
    public static  void main(String [] args){
        BinaryTree root = BinaryTreeBuilder.buildBinaryTree(List.of(1,2,3,4,65,6,7,9,1,2));
        System.out.print(getHeight(root));
    }


    private static int getHeight(BinaryTree node){
        if(node==null)
            return 0;
        int leftHeight= getHeight(node.left);
        int rightHeight = getHeight(node.right);
        if(leftHeight>rightHeight)
            return leftHeight+1;
        else
            return rightHeight+1;
    }

}
