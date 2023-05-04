package easy_rev;

import intro.BinaryTree;
import intro.BinaryTreeBuilder;

import java.util.List;

// check depth of one leaf
// check if all leave are at same level
// check either all nodes are null are none

public class CheckIfPerfect {
    public static void main(String[] args) {
        BinaryTree node = BinaryTreeBuilder.buildBinaryTree(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15
                ));
        int de = getDepth(node);
        System.out.print(isPerfrect(node, de,0));
    }

    public static  int getDepth(BinaryTree node){
        if(node==null)
            return 0;
        if(node.left==null && node.right==null)
            return 1;
        return getDepth(node.left)+1;
    }

    public static  boolean isPerfrect(BinaryTree node, int depth, int level){
        if(node==null)
            return true;
        if(node.left==null && node.right==null){
            return level+1==depth;
        }
        if(node.left==null || node.right==null)
            return false;
       return isPerfrect(node.left, depth, level+1) && isPerfrect(node.right, depth, level+1);
    }

}
