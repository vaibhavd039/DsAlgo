package base;

import java.util.LinkedList;
import java.util.Queue;

public class BSTIterator {
    public static void inOrder(BST node) {
        if (node == null)
            return;
        inOrder(node.left);
        System.out.print(node.data + "\t");
        inOrder(node.right);
    }

    public static void preOrder(BST node) {
        if (node == null)
            return;
        System.out.print(node.data + "\t");
        preOrder(node.left);
        preOrder(node.right);
    }

    public static void postOrder(BST node) {
        if (node == null)
            return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.data + "\t");
    }

    public static void levelOrder(BST node) {
        if (node == null)
            return;
        Queue<BST> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            BST temp = queue.poll();
            if (temp == null)
                continue;
            System.out.print(temp.data + "\t");
            queue.add(temp.left);
            queue.add(temp.right);
        }
    }
}
