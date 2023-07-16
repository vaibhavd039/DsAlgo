package easy;

import base.BST;
import base.BSTIterator;
import base.BinaryTree;
import base.BinaryTreeBuilder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinaryTreeToBST {
    static List<Integer> mylist = new ArrayList<>();

    public static void main(String[] args) {
        BinaryTree node = BinaryTreeBuilder.buildBasicBinaryTree();
        buildList(node);
        Collections.sort(mylist);
        BST bst = createBSTFromArray(mylist, 0, mylist.size()-1);
        BSTIterator.inOrder(bst);
    }

    public static void buildList(BinaryTree node) {
        if (node == null)
            return;
        mylist.add(node.data);
        buildList(node.left);
        buildList(node.right);

    }

    public static BST createBSTFromArray(List<Integer> mylist, int start, int end) {
        if (start > end)
            return null;
        if (start == end) {
            return new BST(mylist.get(start));
        }
        int mid = (start + end) / 2;
        BST root = new BST(mylist.get(mid));
        root.left = createBSTFromArray(mylist, start,mid-1);
        root.right = createBSTFromArray(mylist, mid+1,end);
        return root;
    }
}
