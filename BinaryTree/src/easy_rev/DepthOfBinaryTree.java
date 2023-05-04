package easy_rev;

import intro.BinaryTree;
import intro.BinaryTreeBuilder;

import java.util.List;

public class DepthOfBinaryTree {
    public static void main(String [] ags){
        String tree = "nlnll";
        System.out.print(getDepth(tree,0));

    }

    public static int getDepth(String tree, int index){
        if(index>tree.length() || tree.charAt(index)=='l')
            return 0;
        index ++;
        int leftDepth = getDepth(tree, index);
        index++;
        int rightDepth = getDepth(tree, index);
        return Math.max(leftDepth, rightDepth)+1;
    }


}
