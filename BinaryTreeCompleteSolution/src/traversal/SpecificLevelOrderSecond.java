package traversal;

import base.BinaryTree;
import base.BinaryTreeBuilder;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class SpecificLevelOrderSecond {
    public static void main(String[] args) {
        BinaryTree node = BinaryTreeBuilder.buildBinaryTree(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 13, 14, 15, 16));
        specificTraversalTwo(node);
    }

    public static void specificTraversalTwo(BinaryTree node) {
        if (node == null)
            return;
        Stack<BinaryTree> stack = new Stack<>();
        Queue<BinaryTree> queue = new LinkedList<>();
        stack.push(node);
        queue.add(node.left);
        queue.add(node.right);
        while (!queue.isEmpty()) {
            BinaryTree temp1 = queue.poll();
            BinaryTree temp2 = queue.poll();
            if (temp1 == null)
                continue;
            stack.push(temp2);
            stack.push(temp1);

            queue.add(temp1.right);
            queue.add(temp2.left);
            queue.add(temp1.left);
            queue.add(temp2.right);
        }
        while (!stack.isEmpty()) {
            BinaryTree temp = stack.pop();
            System.out.print(temp.data + "\t");
        }
    }
}
