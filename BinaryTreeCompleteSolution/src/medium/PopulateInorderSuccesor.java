package medium;

class CustomBinaryTree {
    int data;
    CustomBinaryTree left, right, next;

    CustomBinaryTree(int data) {
        this.data = data;
    }
}

public class PopulateInorderSuccesor {
    static CustomBinaryTree prevnode = null;

    public static void main(String[] args) {
        CustomBinaryTree node = new CustomBinaryTree(1);
        node.left = new CustomBinaryTree(2);
        node.right = new CustomBinaryTree(3);
        node.left.left = new CustomBinaryTree(4);
        node.left.right = new CustomBinaryTree(5);
        node.right.left = new CustomBinaryTree(6);
        node.right.right = new CustomBinaryTree(7);
        populateInorderSuccesor(node);
        inOrder(node);
    }


    public static void populateInorderSuccesor(CustomBinaryTree node) {
        if (node == null)
            return;
        populateInorderSuccesor(node.left);
        if (prevnode == null) {
            prevnode = node;
        } else {
            prevnode.next = node;
            prevnode = node;
        }
        populateInorderSuccesor(node.right);

    }

    public static void inOrder(CustomBinaryTree node) {
        if (node == null)
            return;
        inOrder(node.left);
        int nextData = node.next == null ? -1 : node.next.data;
        System.out.println(node.data + " next is " + nextData);
        inOrder(node.right);
    }
}
