package easy;

import intro.BinaryTree;
import intro.BinaryTreeBuilder;

import java.util.List;

public class SubtreeWithGivenSum {
    static boolean isSumAvaialable =false;
    public static void main(String [] args){
        BinaryTree node= BinaryTreeBuilder.buildBinaryTree(List.of(1,3,2,7,6,5,4));
        checkWithGivenSum(node,16);
        System.out.print(isSumAvaialable);
    }

    public static int checkWithGivenSum(BinaryTree node, int sum){
        if(node==null)
            return 0;
        int Lsum = checkWithGivenSum(node.left, sum);
        int rsum = checkWithGivenSum(node.right, sum);
        if( node.data+Lsum + rsum==sum){
            isSumAvaialable=true;
        }
        return Lsum+rsum+node.data;
    }

}
