package easy;

import intro.BinaryTree;
import intro.BinaryTreeBuilder;

import java.util.List;
//Given a Binary Tree, find if there exists an edge whose removal creates two trees of equal size.
//


public class CheckifRemoingEdgeWilldevide {
    public static  int size= 0;
    public static  boolean possilbe= false;
    public static void main(String [] args){
        BinaryTree node= BinaryTreeBuilder.buildBinaryTree(List.of(1,3,2,7,6,5,4,8));
        size=getSizeOfTree(node);
        checkIfPossibleToDevide(node,0);
        System.out.print(possilbe);
    }

    public static int getSizeOfTree(BinaryTree node){
        if(node==null)
            return 0;
        return getSizeOfTree(node.left) + getSizeOfTree(node.right)+1;
    }

    public static int checkIfPossibleToDevide(BinaryTree node, int level){
        if(node==null)
            return 0;

        level = checkIfPossibleToDevide(node.left,level)+1+checkIfPossibleToDevide(node.right,level);
        if(size-level==level){
            possilbe=true;
        }
        return level;
    }

}
