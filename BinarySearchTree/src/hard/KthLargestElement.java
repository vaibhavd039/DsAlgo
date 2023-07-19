package hard;

import base.BST;
import base.BSTIterator;
import base.BinaryTreeToBSTBuilder;

public class KthLargestElement {
    static int counter = 1;
    static int kthNode = 0;

    public static void main(String[] args) {
        BST node = BinaryTreeToBSTBuilder.buildSamplerBST();
        BSTIterator.inOrder(node);
        System.out.print("\n");
        KthLargestBuilder(node, 5);
        System.out.print(kthNode);
    }

    public static void KthLargestBuilder(BST node, int k) {
        if (node == null)
            return;
        KthLargestBuilder(node.right, k);
        if (counter == k) {
            kthNode = node.data;
        }
        counter++;
        KthLargestBuilder(node.left, k);
    }
}
