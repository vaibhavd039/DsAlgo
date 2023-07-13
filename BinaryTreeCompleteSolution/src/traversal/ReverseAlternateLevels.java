package traversal;

import base.BinaryTree;
import base.BinaryTreeBuilder;
import base.BinaryTreeIterator;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ReverseAlternateLevels {
    static boolean isOddLevel = true;

    public static void main(String[] args) {
        BinaryTree node = BinaryTreeBuilder.buildBinaryTree(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15));
        reverseAlternateLevels(node);
        BinaryTreeIterator.levelOrderTraversal(node);
    }

    public static void reverseAlternateLevels(BinaryTree node) {
        if (node == null)
            return;
        Queue<BinaryTree> queue = new LinkedList<>();
        queue.add(node.left);
        queue.add(node.right);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i+=2) {
                BinaryTree temp1 = queue.poll();
                BinaryTree temp2 = queue.poll();
                if (temp1 == null)
                    continue;
                queue.add(temp1.left);
                queue.add(temp2.right);
                queue.add(temp1.right);
                queue.add(temp2.left);
                if (isOddLevel) {
                    int x = temp1.data;
                    temp1.data = temp2.data;
                    temp2.data = x;
                }
            }
            isOddLevel = !isOddLevel;
        }
    }
}
