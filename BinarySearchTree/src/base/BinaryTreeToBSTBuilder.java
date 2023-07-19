package base;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinaryTreeToBSTBuilder {
    private static List<Integer> mylist = new ArrayList<>();

    public static BST buildSamplerBST(BinaryTree node) {
        buildList(node);
        Collections.sort(mylist);
        BST bst = createBSTFromArray(mylist, 0, mylist.size() - 1);
        mylist = new ArrayList<>();
        return bst;
    }

    public static BST buildSamplerBST(List<Integer> elements) {
        BinaryTree node = BinaryTreeBuilder.buildBinaryTree(elements);
        buildList(node);
        Collections.sort(mylist);
        BST bst = createBSTFromArray(mylist, 0, mylist.size() - 1);
        mylist = new ArrayList<>();
        return bst;
    }

    public static BST buildSamplerBST() {
        BinaryTree node = BinaryTreeBuilder.buildBasicBinaryTree();
        buildList(node);
        Collections.sort(mylist);
        BST bst = createBSTFromArray(mylist, 0, mylist.size() - 1);
        mylist = new ArrayList<>();
        return bst;
    }


    private static void buildList(BinaryTree node) {
        if (node == null)
            return;
        mylist.add(node.data);
        buildList(node.left);
        buildList(node.right);

    }

    private static BST createBSTFromArray(List<Integer> mylist, int start, int end) {
        if (start > end)
            return null;
        if (start == end) {
            return new BST(mylist.get(start));
        }
        int mid = (start + end) / 2;
        BST root = new BST(mylist.get(mid));
        root.left = createBSTFromArray(mylist, start, mid - 1);
        root.right = createBSTFromArray(mylist, mid + 1, end);
        return root;
    }

}
