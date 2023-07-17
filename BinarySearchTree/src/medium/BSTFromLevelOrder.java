package medium;

import base.BST;
import base.BSTIterator;

import java.util.List;
import java.util.stream.Collectors;

public class BSTFromLevelOrder {
    public static void main(String[] args) {
        List<Integer> levelOrder = List.of(7, 4, 12, 3, 6, 8, 1, 5, 10);
        BST node = createTree(levelOrder);
        BSTIterator.inOrder(node);
    }

    public static BST createTree(List<Integer> levelOrder) {
        if (levelOrder.isEmpty())
            return null;
        int rootData = levelOrder.get(0);
        List<Integer> leftElements =
                levelOrder.stream().filter(element -> element < rootData).collect(Collectors.toList());
        List<Integer> rigtElements =
                levelOrder.stream().filter(element -> element > rootData).collect(Collectors.toList());
        BST root = new BST(rootData);
        root.left = createTree(leftElements);
        root.right = createTree(rigtElements);
        return root;
    }
}
