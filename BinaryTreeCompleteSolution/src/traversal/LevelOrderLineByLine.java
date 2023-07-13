package traversal;

import base.BinaryTree;
import base.BinaryTreeBuilder;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderLineByLine {
    public static void main(String[] args) {
        BinaryTree node = BinaryTreeBuilder.buildBasicBinaryTree();
        levelOrderLineByLine(node);

    }

    public static void levelOrderLineByLine(BinaryTree node) {
        if (node == null)
            return;
        Queue<BinaryTree> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                BinaryTree temp = queue.poll();
                if(temp==null)
                    continue;
                System.out.print(temp.data+"\t");
                queue.add(temp.left);
                queue.add(temp.right);
            }
            System.out.print("\n");
        }
    }

}
