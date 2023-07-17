package medium;

import base.BST;
import base.BSTBuilder;

import java.util.ArrayList;
import java.util.List;

public class FindPairWithSum {
    static List<Integer> inorder = new ArrayList<>();

    public static void main(String[] args) {
        BST node = BSTBuilder.buildSampleBST();
        createInorderList(node);
        System.out.print(findPairWithSum(25));

    }

    public static boolean findPairWithSum(int sum) {
        int start = 0;
        int end = inorder.size() - 1;
        int size = inorder.size();
        while (start <= end) {
            if (inorder.get(start) + inorder.get(end) == sum) {
                return true;
            }
            if (inorder.get(start) + inorder.get(end) < sum) {
                start++;
            }
            if (inorder.get(start) + inorder.get(end) > sum) {
                end--;
            }
        }
        return false;
    }

    public static void createInorderList(BST node) {
        if (node == null)
            return;
        createInorderList(node.left);
        inorder.add(node.data);
        createInorderList(node.right);
    }
}
