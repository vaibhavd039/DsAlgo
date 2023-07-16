package easy;

import base.BST;
import base.BSTBuilder;
import base.BSTIterator;

public class SumOfKSmallElements {
    static int counter = 1;
    static int sum = 0;

    public static void main(String[] args) {
        BST node = BSTBuilder.buildSampleBST();
        System.out.print(getSumOfKElements(node, 5));

    }

    public static int getSumOfKElements(BST node, int k) {
        if (node == null)
            return 0;
        int result = getSumOfKElements(node.left, k);
        if (counter > k) {
            return result;
        }
        result += node.data;
        counter++;
        if (counter >= k) {
            return result;
        }
        return result + getSumOfKElements(node.right, k);
    }


}
