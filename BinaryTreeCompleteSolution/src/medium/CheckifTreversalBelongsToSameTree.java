package medium;
//Check if given Preorder, Inorder and Postorder traversals are of same tree

import base.BinaryTree;
import base.BinaryTreeIterator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// idea is to create tree using inorder and preorder
//validate using postorder
public class CheckifTreversalBelongsToSameTree {
    static Map<Integer, Integer> valueIndexMap = new HashMap<>();
    static int preIndex = 0;
    static boolean isRightPostOrder = true;
    static int index=0;

    public static void main(String[] args) {
        List<Integer> inOrder = List.of(8, 4, 9, 2, 5, 1, 6, 3, 7);
        List<Integer> preOrder = List.of(1, 2, 4, 8, 9, 5, 3, 6, 7);
        List<Integer> postOrder = List.of(8, 9, 4, 5, 2, 6, 7, 3, 1);
        createHashMap(inOrder);
        BinaryTree node = createTree(inOrder, preOrder, 0, inOrder.size() - 1);
        BinaryTreeIterator.postOrderTraversal(node);
        checkPostOrder(node, postOrder);
        System.out.print(isRightPostOrder);
    }

    public static BinaryTree createTree(List<Integer> inOrder, List<Integer> preOrder, int start, int end) {
        if (start > end)
            return null;
        if (start == end)
            return new BinaryTree(preOrder.get(preIndex++));
        int rootIndex = valueIndexMap.get(preOrder.get(preIndex++));
        BinaryTree node = new BinaryTree(inOrder.get(rootIndex));
        node.left = createTree(inOrder, preOrder, start, rootIndex - 1);
        node.right = createTree(inOrder, preOrder, rootIndex + 1, end);
        return node;
    }

    public static void createHashMap(List<Integer> inOrder) {
        valueIndexMap = IntStream.range(0, inOrder.size())
                .boxed()
                .collect(Collectors.toMap(inOrder::get, i -> i));
    }

    public static void checkPostOrder(BinaryTree node, List<Integer> postOder) {
        if (node == null)
            return;
        checkPostOrder(node.left, postOder);
        checkPostOrder(node.right, postOder);
        if (node.data != postOder.get(index)) {
            isRightPostOrder = false;
        }
        index++;

    }

}
