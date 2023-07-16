package base;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeOperator {
    public static void insertElementInTree(BinaryTree node, int data) {
        if (node == null) {
            node = new BinaryTree(data); return;
        } Queue<BinaryTree> queue = new LinkedList<>(); queue.add(node); while (!queue.isEmpty()) {
            BinaryTree temp = queue.poll();
            if (temp == null) continue; if (temp.left == null) {
                temp.left = new BinaryTree(data); return;
            } else {
                queue.add(temp.left);

            }

            if (temp.right == null) {
                temp.right = new BinaryTree(data); return;
            } else {
                queue.add(temp.right);
            }
        }
    }

    public static void deleteElementFromTree(BinaryTree node, int data) {
        if (node == null) {
            return;
        } if (node.left == null && node.right == null) {
            if (node.data == data) node = null; return;
        } BinaryTree keyNode = null, temp = null; Queue<BinaryTree> queue = new LinkedList<>(); queue.add(node);
        while (!queue.isEmpty()) {
            temp = queue.poll(); if (temp.data == data) {
                keyNode = temp;
            } if (temp.left != null) {
                queue.add(temp.left);
            } if (temp.right != null) {
                queue.add(temp.right);
            }
        } if (keyNode != null) {
            int x = temp.data; keyNode.data = temp.data; deleteTheRightMostNode(node, x);
        }
    }


    private static void deleteTheRightMostNode(BinaryTree node, int x) {
        Queue<BinaryTree> queue = new LinkedList<>(); queue.add(node); BinaryTree temp = null;
        while (!queue.isEmpty()) {
            temp = queue.poll(); if (temp == null) continue; if (temp.left != null && temp.left.data == x) {
                temp.left = null; return;
            } else {
                queue.add(temp.left);
            }

            if (temp.right != null && temp.right.data == x) {
                temp.right = null; return;
            } else {
                queue.add(temp.right);
            }
        }
    }


}
