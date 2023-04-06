package traversal;

//Given a binary tree, print the level order traversal in such a way that first two levels are printed from left to right,
// next two levels are printed from right to left, then next two from left to right and so on. So, the problem is to reverse
// the direction of level order traversal of binary tree after every two levels.

import intro.BinaryTree;
import intro.BinaryTreeBuilder;
import intro.BinaryTreeIterator;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class DirectionChangeAfterTwoLines {
    public static void main(String[] args) {
        BinaryTree root = BinaryTreeBuilder.buildBinaryTree(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9));
        BinaryTreeIterator.levelOrderTraversal(root);
        System.out.print("\n");
        printNodeWithDirectionChangeAfterTwoLevels(root);
    }

    public static void printNodeWithDirectionChangeAfterTwoLevels(BinaryTree root) {
        Queue<BinaryTree> queue = new LinkedList<>();
        Stack<BinaryTree> st = new Stack<>();
        boolean leftToRight = true;
        int counter = 0;
        if (root == null)
            return;
        queue.add(root);
        while (!(queue.isEmpty() && st.isEmpty())) {
            int size = queue.size();
            counter++;
            for (int i = 0; i < size; i++) {
                BinaryTree temp = queue.poll();
                if (leftToRight) {
                    System.out.print(temp.data + "\t");
                } else {
                    st.push(temp);
                }
                if (temp.left != null)
                    queue.add(temp.left);
                if (temp.right != null)
                    queue.add(temp.right);
            }
            if (!leftToRight) {
                while (!st.isEmpty()) {
                    BinaryTree node = st.pop();
                    System.out.print(node.data + "\t");
                }
            }

            if (counter == 2) {
                leftToRight = !leftToRight;
                counter = 0;
            }
        }

    }
}
