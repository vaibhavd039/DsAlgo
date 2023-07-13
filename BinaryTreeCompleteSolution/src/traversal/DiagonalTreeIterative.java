package traversal;

import base.BinaryTree;
import base.BinaryTreeBuilder;

import java.util.LinkedList;
import java.util.Queue;

public class DiagonalTreeIterative {
    public static void main(String[] args) {
        BinaryTree node = BinaryTreeBuilder.buildBasicBinaryTree();
        diagonalTree(node);
    }

    public static void diagonalTree(BinaryTree node) {
        Queue<BinaryTree> queue = new LinkedList<>();

        while (!queue.isEmpty() || node != null) {
            if (node != null) {
                System.out.print(node.data+"\t");
                if (node.left != null)
                    queue.add(node.left);
                node = node.right;
            } else {
                node = queue.poll();
                System.out.print("\n");
            }
        }
    }
}
