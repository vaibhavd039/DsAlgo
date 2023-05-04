package easy_rev;

import intro.BinaryTree;
import intro.BinaryTreeBuilder;

import java.util.List;

public class SubTreeWithGivenSum {
    public static int sum =0;
    static boolean sumAvailabe = false;
    public static void main(String [] args){
        BinaryTree node = BinaryTreeBuilder.buildBinaryTree(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15
                , 16, 17, 18, 19, 20));
        sum = 210;
        getSum(node);
        System.out.print(sumAvailabe);
    }

    public static int getSum(BinaryTree node){
        if(node==null)
            return 0;
        int leftSum = getSum(node.left);
        int rightSum = getSum(node.right);
        if(node.data+leftSum+rightSum==sum){
            sumAvailabe=true;
        }
        return node.data+leftSum+rightSum;
    }
}
