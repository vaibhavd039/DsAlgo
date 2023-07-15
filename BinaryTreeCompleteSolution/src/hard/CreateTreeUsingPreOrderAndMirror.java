package hard;

import base.BinaryTree;
import base.BinaryTreeIterator;

import java.util.List;

public class CreateTreeUsingPreOrderAndMirror {
    static int index = 0;

    public static void main(String[] args) {
        List pre = List.of(1, 2, 4, 5, 3, 6, 7);
        List mirror = List.of(1, 3, 7, 6, 2, 5, 4);
        BinaryTree node = createTree(pre, mirror, 0, pre.size() - 1, mirror.size());
        BinaryTreeIterator.levelOrderTraversal(node);
    }

    public static BinaryTree createTree(List<Integer> preOrder, List<Integer> mirror, int left, int right, int size) {
        if (left > right || index >= size) {
            return null;
        }

        BinaryTree node = new BinaryTree(preOrder.get(index));
        index++;
        if (left == right) {
            return node;
        }
        int i;
        for (i = left; i < right; i++) {
            if (mirror.get(i) == preOrder.get(index)) {
                break;
            }
        }
        if (i <= right) {
            node.left = createTree(preOrder, mirror, i, right, size);
            node.right = createTree(preOrder, mirror, left + 1, i - 1, size);
        }
        return node;
    }
}
