package easy;

import intro.BinaryTree;
import intro.BinaryTreeBuilder;

import java.util.List;

public class CheckPerfectBinaryTree {
    public static int depth=1;
    public static void main(String [] args){
        BinaryTree node = BinaryTreeBuilder.buildBinaryTree(List.of(1,2,3,4,5,6,7));
        initDepth(node);
        System.out.print(checkIfPerfectTree(node,0));
    }

    public static void initDepth(BinaryTree curr){
        while(curr.left!=null){
            curr=curr.left;
            depth++;
        }
    }

    public static boolean checkIfPerfectTree(BinaryTree node, int level){
        if(node==null)
            return true;
        if(node.left==null && node.right==null){
            return depth==level+1;
        }
        if(node.left==null || node.right==null){
            return false;
        }
        return checkIfPerfectTree(node.left, level+1) && checkIfPerfectTree(node.right, level+1);
    }

}
