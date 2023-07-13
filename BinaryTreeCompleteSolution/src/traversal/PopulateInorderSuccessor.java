package traversal;
//Given a Binary Tree where each node has the following structure,
//        write a function to populate the next pointer for all nodes.
//        The next pointer for every node should be set to point to in-order successor.

class CustomBinaryTree {
    int data;
    CustomBinaryTree left;
    CustomBinaryTree right;
    CustomBinaryTree next;

    CustomBinaryTree(int data) {
        this.data = data;
    }
}

public class PopulateInorderSuccessor {
    static CustomBinaryTree prevNode;

    public static void main(String[] args) {
        CustomBinaryTree root = new CustomBinaryTree(1);
        root.left = new CustomBinaryTree(2);
        root.right = new CustomBinaryTree(3);
        root.left.left = new CustomBinaryTree(4);
        root.left.right = new CustomBinaryTree(5);
        root.right.left = new CustomBinaryTree(6);
        root.right.right = new CustomBinaryTree(7);
        populateInOrderSuccesor(root);
        inOrderCustom(root);

    }

    public static void populateInOrderSuccesor(CustomBinaryTree node) {
        if (node == null)
            return;
        populateInOrderSuccesor(node.left);
        if (prevNode == null) {
            prevNode = node;
        } else {
            prevNode.next = node;
            prevNode=node;
        }
        populateInOrderSuccesor(node.right);
    }

    public static void inOrderCustom(CustomBinaryTree node) {
        if (node == null)
            return;
        inOrderCustom(node.left);
        int nextData=node.next != null ? node.next.data : -1;
        System.out.println(node.data + "\t next is \t" + nextData);
        inOrderCustom(node.right);
    }

}
