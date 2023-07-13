package traversal;

import base.BinaryTree;
import base.BinaryTreeBuilder;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderChangeDirectionAfterTwoLevels {
    static boolean leftToRight = true;
    static int counter = 1;

    public static void main(String[] args) {
        BinaryTree node = BinaryTreeBuilder.buildBasicBinaryTree();
        levelOrderChangeDirectionAfterTwoLevels(node);

    }

    public static void levelOrderChangeDirectionAfterTwoLevels(BinaryTree node) {

        if (node == null)
            return;
        Queue<BinaryTree> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                BinaryTree temp = queue.poll();
                if (temp == null)
                    continue;
                System.out.print(temp.data + "\t");
                if (leftToRight) {
                    queue.add(temp.left);
                    queue.add(temp.right);
                } else {
                    queue.add(temp.right);
                    queue.add(temp.left);
                }
            }
            System.out.print("\n");
            counter++;
            if (counter == 2) {
                leftToRight = !leftToRight;
                counter = 0;
            }
        }
    }

}
