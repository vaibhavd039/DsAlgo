package hard;
//Count pairs from two BSTs whose sum is equal to a given value x


import base.BST;
import base.BinaryTreeToBSTBuilder;

import java.util.List;
import java.util.Stack;

public class CountPairFromTwoBST {
    public static void main(String[] args) {
        BST node1 = BinaryTreeToBSTBuilder.buildSamplerBST(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9));
        BST node2 = BinaryTreeToBSTBuilder.buildSamplerBST(List.of(11, 12, 13, 14, 15, 16, 17, 18, 19));
        System.out.print(findPairWithSum(node1, node2, 28));
    }

    public static int findPairWithSum(BST node1, BST node2, int sum) {
        if (node1 == null && node2 == null)
            return 0;
        int counter = 0;
        Stack<BST> stack1 = new Stack<>();
        Stack<BST> stack2 = new Stack<>();
        while (true) {
            while (node1 != null) {
                stack1.push(node1);
                node1 = node1.left;
            }

            while (node2 != null) {
                stack2.push(node2);
                node2 = node2.right;
            }

            if (stack1.isEmpty() || stack2.isEmpty())
                break;
            BST top1 = stack1.peek();
            BST top2 = stack2.peek();
            if (top1.data + top2.data == sum) {
                counter++;
                stack2.pop();
                stack1.pop();
                node1 = top1.right;
                node2 = top2.left;
            }
            if (top1.data + top2.data < sum) {
                stack1.pop();
                node1 = top1.right;
            }
            if (top1.data + top2.data > sum) {
                stack2.pop();
                node2 = top2.left;
            }
        }
        return counter;
    }
}
