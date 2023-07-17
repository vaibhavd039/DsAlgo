package medium;

import base.BST;
import base.BSTBuilder;

public class LCAinBST {
    public static void main(String[] args) {
        BST node = BSTBuilder.buildSampleBST();
        BST mynode = getLCA(node, 8, 3);
        System.out.print(mynode.data);
    }

    public static BST getLCA(BST node, int a, int b) {
        while (node != null) {
            if (node.data < a && node.data < b) {
                node = node.right;
            } else if (node.data > a && node.data > b) {
                node = node.left;
            } else {
                break;
            }

        }
        return node;
    }

}
