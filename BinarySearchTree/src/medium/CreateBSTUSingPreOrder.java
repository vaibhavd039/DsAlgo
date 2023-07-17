package medium;

import base.BST;
import base.BSTIterator;

import java.util.List;

public class CreateBSTUSingPreOrder {
    static int index = 0;

    public static void main(String[] args) {
        List<Integer> mylist = List.of(10, 5, 1, 7, 40, 50);
        BST node = createTree(mylist, mylist.get(0), Integer.MIN_VALUE, Integer.MAX_VALUE, mylist.size());
        BSTIterator.inOrder(node);
    }

    public static BST createTree(List<Integer> preOrder, int root, int min, int max, int size) {
        if (index >= size) {
            return null;
        }
        BST node = null;
        if (root > min && root < max) {
            node = new BST(root);
            index++;
            if (index < size) {
                node.left = createTree(preOrder, preOrder.get(index), min, root, size);
            }
            if (index < size) {
                node.right = createTree(preOrder, preOrder.get(index), root, max, size);
            }
        }
        return node;
    }
}
