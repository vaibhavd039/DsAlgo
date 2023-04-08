package traversal;

import intro.BinaryTree;
import intro.BinaryTreeBuilder;

import java.util.List;

public class DensityOfBinaryTree {
    public static void main(String [] args){
        BinaryTree node = BinaryTreeBuilder.buildBinaryTree(List.of(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20));
        printDensityOfTree(node);
    }
    static int size= 0;
    public static  void printDensityOfTree(BinaryTree node){
        int height = getHeight(node);
        System.out.print((double)size/height);
    }

    public static int getHeight(BinaryTree node){
        if(node==null)
            return 0;
        size++;
        int leftHeight= getHeight(node.left);
        int rightHeight = getHeight(node.right);
        return  leftHeight>rightHeight?leftHeight+1:rightHeight+1;
    }
}
