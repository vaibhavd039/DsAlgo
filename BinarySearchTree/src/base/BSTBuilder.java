package base;

public class BSTBuilder {
    public static BST buildSampleBST() {
        BST node = new BST(10);
        node.left = new BST(6);
        node.left.left = new BST(2);
        node.left.right = new BST(8);
        node.left.left.left = new BST(1);
        node.left.left.right = new BST(4);
        node.left.left.right.left = new BST(3);
        node.left.left.right.right = new BST(5);
        node.left.right.left = new BST(7);
        node.left.right.right = new BST(9);


        node.right = new BST(15);
        node.right.left = new BST(13);
        node.right.left.left = new BST(12);
        node.right.left.left.left = new BST(11);
        node.right.left.right = new BST(14);

        node.right.right = new BST(19);
        node.right.right.right = new BST(20);

        node.right.right.left = new BST(17);
        node.right.right.left.left = new BST(16);
        node.right.right.left.right = new BST(18);
        return node;
    }
}
