package medium;

import base.BinaryTree;
import base.BinaryTreeBuilder;
import base.BinaryTreeIterator;

import java.util.List;

class Largest {
    int min, max, size;

    Largest(int min, int max, int size) {
        this.min = min;
        this.max = max;
        this.size = size;
    }
}

public class FindLargestBST {
    public static void main(String[] args) {
        BinaryTree node = new BinaryTree(5);
        node.left = new BinaryTree(3);
        node.left.left = new BinaryTree(2);
        node.left.right = new BinaryTree(4);

        node.right = new BinaryTree(8);
        node.right.left = new BinaryTree(7);
        node.right.right = new BinaryTree(9);

        BinaryTreeIterator.inOrderTraversal(node);
        System.out.print("\n");
        Largest tree = getLargestTree(node);
        System.out.print(tree.size + "\t");
    }

    public static Largest getLargestTree(BinaryTree node) {
        if (node == null) {
            return new Largest(Integer.MIN_VALUE, Integer.MAX_VALUE, 0);
        }
        if (node.left == null && node.right == null) {
            return new Largest(node.data, node.data, 1);
        }

        Largest left = getLargestTree(node.left);
        Largest right = getLargestTree(node.right);
        if (left.max < node.data && right.min > node.data) {
            int new_min = Math.min(left.min, Math.min(node.data, right.min));
            int new_max = Math.max(right.max, Math.min(node.data, left.max));
            int size = left.size+ right.size + 1;
            return new Largest(new_min, new_max, size);
        } else {
            return new Largest(Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(left.size, right.size));
        }
    }
}
