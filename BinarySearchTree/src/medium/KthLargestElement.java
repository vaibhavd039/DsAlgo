package medium;

import base.BST;
import base.BSTBuilder;

//K’th Largest element in BST using constant extra space
public class KthLargestElement {
    static int kthLargest = 0;

    public static void main(String[] args) {

        BST node = BSTBuilder.buildSampleBST();
        kthLargestElement(node, 5);
        System.out.print(kthLargest);
    }

    public static void kthLargestElement(BST node, int k) {
        int counter = 0;
        BST curr;
        while (node != null) {
            if (node.right != null) {
                curr = node.right;
                while (curr.left != null && curr.left != node) {
                    curr = curr.left;
                }
                if (curr.left == null) {
                    curr.left = node;
                    node = node.right;
                } else {
                    curr.left = null;
                    if (++counter == k) {
                        kthLargest = node.data;
                    }
                    node = node.left;
                }
            } else {
                if (++counter == k) {
                    kthLargest = node.data;
                }
                node = node.left;
            }
        }
    }

}
