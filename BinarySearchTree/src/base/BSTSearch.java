package base;

public class BSTSearch {
    public static BST searchNodeData(BST node, int x) {
        if (node == null)
            return null;
        if (node.data == x) {
            return node;
        }
        if (node.data > x) {
            return searchNodeData(node.left, x);
        } else {
            return searchNodeData(node.right, x);
        }
    }

}
