package easy_rev;

import intro.BinaryTree;
import intro.BinaryTreeBuilder;

import java.util.List;
import java.util.Set;

public class CheckIfCousins {
    public static void main(String [] args){
        BinaryTree node = BinaryTreeBuilder.buildBinaryTree(List.of(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20));
        System.out.print(checkCousins(node, 4,6));
    }
    public static boolean checkCousins(BinaryTree node, int a, int b) {
        return (getLevel(node, a, 0) == getLevel(node, b, 0)) && !isSublings(node, a,b);
    }

    public static boolean isSublings(BinaryTree node, int a , int b){
            if(node==null)
                return false;
            if(node.left==null || node.right==null)
                return false;
                if(node.left==null && node.right!=null) {
                return  isSublings(node.right, a,b);
                }
                if(node.left!=null && node.right==null) {
                    return  isSublings(node.left, a,b);
                }
           return ((node.left.data==a && node.right.data==b) || (node.left.data==b && node.right.data==a)
                   || isSublings(node.left, a,b) || isSublings(node.right,a,b));
    }

    public static int getLevel(BinaryTree node, int data, int level){
        if(node==null)
            return 0;
        if(node.data==data)
            return level;
        int llevel = getLevel(node.left, data, level+1);
        if(llevel!=0)
            return llevel;
        return getLevel(node.right, data, level+1);
    }
}
