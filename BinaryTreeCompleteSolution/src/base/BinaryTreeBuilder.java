package base;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeBuilder {

    public static BinaryTree buildBinaryTree(List<Integer> elements) {
        BinaryTree root = new BinaryTree(elements.get(0));
        Queue<BinaryTree> queue = new LinkedList<>();
        queue.add(root);
        int counter = 1;
        while (counter < elements.size()) {
            BinaryTree temp = queue.poll();
            temp.left = new BinaryTree(elements.get(counter++));
            queue.add(temp.left);
            if (counter < elements.size()) {
                temp.right = new BinaryTree(elements.get(counter++));
                queue.add(temp.right);
            }
        }
        return root;
    }

    public static BinaryTree buildBasicBinaryTree() {
        List<Integer> elements = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 13, 15, 16, 17, 18, 19);
        return buildBinaryTree(elements);
    }

}
