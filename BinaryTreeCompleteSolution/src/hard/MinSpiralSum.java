package hard;

//Given a binary tree containing n nodes.
//        The problem is to find the maximum sum obtained when the tree is spirally traversed.

import base.BinaryTree;
import base.BinaryTreeBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MinSpiralSum {
    public static void main(String[] args) {
        BinaryTree node = BinaryTreeBuilder.buildBasicBinaryTree();
        List<Integer> spiralList = getSpiral(node);
        System.out.print(maxSum(spiralList));

    }

    public static int maxSum(List<Integer> mylist) {
        int MAX_SUM = Integer.MIN_VALUE;
        int MAX_SUM_ENDING_HERE = Integer.MIN_VALUE;
        for (int i = 0; i < mylist.size(); i++) {
            if(MAX_SUM_ENDING_HERE< 0){
                MAX_SUM_ENDING_HERE= mylist.get(i);
            } else {
                MAX_SUM_ENDING_HERE+=mylist.get(i);
            }
            MAX_SUM  = Math.max(MAX_SUM, MAX_SUM_ENDING_HERE);

        }
        return MAX_SUM;
    }


    public static List<Integer> getSpiral(BinaryTree node) {
        if (node == null) {
            return new ArrayList<>();
        }
        List<Integer> mylist = new ArrayList<>();
        Stack<BinaryTree> stack1 = new Stack<>();
        Stack<BinaryTree> stack2 = new Stack<>();
        stack1.push(node);
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                BinaryTree temp = stack1.pop();
                if (temp == null)
                    continue;
                mylist.add(temp.data);
                stack2.push(temp.left);
                stack2.push(temp.right);
            }

            while (!stack2.isEmpty()) {

                BinaryTree temp = stack2.pop();
                if (temp == null)
                    continue;
                mylist.add(temp.data);
                stack1.push(temp.left);
                stack1.push(temp.right);
            }

        }
        return mylist;
    }
}
