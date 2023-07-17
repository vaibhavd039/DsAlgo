package medium;

import base.BST;
import base.BSTBuilder;

public class InorderSuccesor {
    static BST valueNode = null;
    static int succ = -1;

    public static void main(String[] args) {
        BST node = BSTBuilder.buildSampleBST();
        getInorderSuccssor(node, 6);
        System.out.print(succ);

    }

    public static void getInorderSuccssor(BST node, int x) {
        if (node == null)
            return;
        getInorderSuccssor(node.left, x);
        if (node.data == x && valueNode == null) {
            valueNode = node;
        } else if (valueNode != null) {
            succ = node.data;
            valueNode = null;
        }
        getInorderSuccssor(node.right, x);
    }
}
