package medium;

import base.BinaryTree;
import base.BinaryTreeBuilder;

public class FindLargetSubTreeSumInTree {
    static int maxSum=Integer.MIN_VALUE;
    public static void main(String[] args) {
        BinaryTree node = BinaryTreeBuilder.buildBasicBinaryTree();
        getMaxSunSubtree(node);
        System.out.print(maxSum);
    }

    public static int getMaxSunSubtree(BinaryTree  node){
        if(node==null){
            return 0;
        }
        int left = getMaxSunSubtree(node.left);
        int right = getMaxSunSubtree(node.right);
        int currrentMax = Math.max(left, right);
        if(currrentMax>maxSum){
            maxSum=currrentMax;
        }
        return node.data+left+right;
    }
}
