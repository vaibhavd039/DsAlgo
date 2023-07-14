package medium;

import base.BinaryTree;
import base.BinaryTreeBuilder;

import java.util.LinkedList;
import java.util.Queue;

//Check whether a given Binary Tree is Complete or not
// the idea is do a level traveral if we find any node which is not full
// then later all node must be a leaf node
public class CheckCompleteBinaryTree {
    static boolean isHalfNodeFound = false;

    public static void main(String[] args) {
        BinaryTree node = BinaryTreeBuilder.buildBasicBinaryTree();
        System.out.print(checkIfCompleteTree(node));
    }

    public static boolean checkIfCompleteTree(BinaryTree node) {
        if (node == null)
            return true;
        Queue<BinaryTree> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            BinaryTree temp = queue.poll();
            if (!isHalfNodeFound) {
                if (isFullNode(temp) && !isLeafNode(temp)) {
                    queue.add(temp.left);
                    queue.add(temp.right);
                } else if (!isFullNode(temp)) {
                    isHalfNodeFound = true;
                }
            } else {
                if(!isLeafNode(temp)){
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isFullNode(BinaryTree node) {
        return node.left != null && node.right != null;
    }

    public static boolean isLeafNode(BinaryTree node) {
        return node.left == null && node.right == null;
    }
}
