package base;

public class BSTOperator {
    public static BST addNewNode(BST node, int data) {
        if (node == null)
            return new BST(data);
        if (node.data >= data) {
            node.left = addNewNode(node.left, data);
        } else if (node.data < data) {
            node.right = addNewNode(node.right, data);
        }
        return node;
    }

    public static BST deleteNode(BST node, int data) {
        if (node == null)
            return null;
        if (node.data > data) {
            deleteNode(node.left, data);
        } else if (node.data < data) {
            deleteNode(node.right, data);
        }

        if (node.left == null) {
            BST temp = node.left;
            return temp;
        } else if (node.right == null) {
            BST temp = node.right;
            return temp;
        } else {
            BST succParent = node;
            BST succ = succParent.right;
            while (succ.left != null) {
                succParent = succ;
                succ = succ.left;
            }

            if (succParent != node) {
                succParent.left = succ.right;
            } else
                succParent.right = succ.right;
            node.data = succ.data;
            return node;
        }

    }


}
