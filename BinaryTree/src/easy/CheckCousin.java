package easy;

import intro.BinaryTree;
import intro.BinaryTreeBuilder;
import intro.BinaryTreeIterator;

//Two nodes are cousins of each other if they are at same level and have different parents.
import java.util.List;

public class CheckCousin {
    public static void main(String [] args){
        BinaryTree node = BinaryTreeBuilder.buildBinaryTree(List.of(1,2,3,4,5,6,7,8,9));
        System.out.print(checkIfCousin(node, 5,7));
    }

    public static boolean checkIfCousin(BinaryTree node, int a , int b){
        return  (getLevel(node, a, 1)== getLevel(node, b, 1)) && !(isSiblings(node,a,b));
    }

    public static int getLevel(BinaryTree node, int value, int level){
        if(node==null)
            return 0;
        if(node.data==value)
            return level;
       int lev=  getLevel(node.left, value, level+1);
       if(lev!=0)
           return lev;
       else
        return getLevel(node.right, value, level+1);
    }

    public static boolean isSiblings(BinaryTree root, int a, int b){
        if(root==null)
            return false;
        if((root.left==null && root.right!=null) || (root.left!=null && root.right==null)){
            return false;
        }
        if(root.left==null && root.right==null){
            return false;
        }
        return ((root.left.data==a && root.right.data==b) || (root.left.data==b && root.right.data==a)) || isSiblings(root.left, a,b )|| isSiblings(root.right,a ,b);
    }


}
