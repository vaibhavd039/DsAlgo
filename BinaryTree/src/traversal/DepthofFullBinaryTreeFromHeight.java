package traversal;

import intro.BinaryTree;
import intro.BinaryTreeBuilder;

import java.util.List;

//Given preorder of a binary tree, calculate its depth(or height) [starting from depth 0]. The preorder is given as a string with two possible characters.
public class DepthofFullBinaryTreeFromHeight {
    public static void main(String [] args){
        String tree = "nlnnlll";
        System.out.print(findDepth(tree, 0));
    }

    public static int findDepth(String tree, int index){
        if(index>tree.length() || tree.charAt(index)=='l'){
            return 0;
        }
        index++;
        int left = findDepth(tree, index);
        index++;
        int right = findDepth(tree, index);
        return Math.max(left,right)+1;
    }
}
