package medium;
//Find k-th smallest element in BST (Order Statistics in BST)

import base.BST;
import base.BSTBuilder;

public class KthSmallestElement {
    static int counter = 0;
    static int kthNode = 0;

    public static void main(String[] args) {
        BST node = BSTBuilder.buildSampleBST();
        BST k = getKthSmallestElement(node, 5);
        System.out.print(k.data);

    }

    public static BST getKthSmallestElement(BST node, int k) {
        if (node == null)
            return null;
        BST left = getKthSmallestElement(node.left, k);
        if (left != null)
            return left;
        counter++;
        if (counter == k)
            return node;
        return getKthSmallestElement(node.right, k);
    }
}
