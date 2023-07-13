package traversal;

import base.BinaryTree;
import base.BinaryTreeBuilder;

import java.util.*;

public class BoundaryofBinaryTree {
    public static void main(String[] args) {
        BinaryTree node = BinaryTreeBuilder.buildBasicBinaryTree();
        printBoundary(node);
    }

    public static void printBoundary(BinaryTree node) {
        List<BinaryTree> boundary = new ArrayList<>();
        boundary.add(node);
        boundary.addAll(getLeftBoundary(node.left));
        boundary.addAll(getleafNodes(node));
        boundary.addAll(getRightBoundary(node.right));
        boundary.stream().forEach(element -> System.out.print(element.data+"\t"));
    }

    public static List<BinaryTree> getLeftBoundary(BinaryTree node) {
        List<BinaryTree> left = new ArrayList<>();
        while (node != null && node.left != null && !isLeaf(node)) {
            left.add(node);
            node = node.left;
        }
        return left;
    }

    private static boolean isLeaf(BinaryTree node) {
        return node.left == null && node.right == null;
    }

    public static List<BinaryTree> getRightBoundary(BinaryTree node) {
        List<BinaryTree> right = new ArrayList<>();
        while (node != null && node.right != null && !isLeaf(node)) {
            right.add(node);
            node = node.right;
        }
        Collections.reverse(right);
        return right;
    }

    public static List<BinaryTree> getleafNodes(BinaryTree node) {
        Queue<BinaryTree> queue = new LinkedList<>();
        List<BinaryTree> leaf = new ArrayList<>();
        queue.add(node);
        while (!queue.isEmpty()) {

            BinaryTree temp = queue.poll();
            if (temp == null)
                continue;
            if (isLeaf(temp)) {
                leaf.add(temp);
            }
            queue.add(temp.left);
            queue.add(temp.right);
        }
        return leaf;
    }

}
