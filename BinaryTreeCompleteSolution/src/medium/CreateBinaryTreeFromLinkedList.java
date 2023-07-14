package medium;

import base.BinaryTree;
import base.BinaryTreeIterator;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CreateBinaryTreeFromLinkedList {
    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 11);
        BinaryTree node = buildBinaryTree(list);
        BinaryTreeIterator.levelOrderTraversal(node);
    }

    public static BinaryTree buildBinaryTree(List<Integer> elements) {
        int counter = 0;
        int size = elements.size();
        BinaryTree node = new BinaryTree(elements.get(counter++));
        Queue<BinaryTree> queue = new LinkedList<>();
        queue.add(node);
        while (counter < size) {
            BinaryTree temp = queue.poll();
            temp.left = new BinaryTree(elements.get(counter++));
            queue.add(temp.left);
            if (counter >= size) {
                return node;
            } else {
                temp.right = new BinaryTree(elements.get(counter++));
            }
            queue.add(temp.right);
        }
        return node;
    }

}
