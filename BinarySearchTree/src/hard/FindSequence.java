package hard;

import base.BST;
import base.BSTIterator;
import base.BinaryTreeToBSTBuilder;

import java.util.List;

public class FindSequence {

    public static void main(String[] args) {
        BST node = BinaryTreeToBSTBuilder.buildSamplerBST();
        List<Integer> elements = List.of(1, 2, 3, 4, 5);
        BSTIterator.inOrder(node);
        System.out.print(checkifSubsequenceExists(node, elements, 0));

    }

    public static boolean checkifSubsequenceExists(BST node, List<Integer> elements, int counter) {
        if (node == null && counter < elements.size())
            return false;
        if (node == null)
            return true;

        boolean isLeft = checkifSubsequenceExists(node.left, elements, counter);
        boolean current = false;
        System.out.println("node data : " + node.data + ", element data: " + elements.get(counter));
        if (node.data == elements.get(counter)) {
            counter++;
            if (counter == elements.size()) {
                current = true;
            }
        }
        boolean isRight = checkifSubsequenceExists(node.right, elements, counter);

        return current && isRight || isLeft;
    }

}
