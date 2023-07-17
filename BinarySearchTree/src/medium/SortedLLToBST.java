package medium;

import base.BST;
import base.BSTIterator;

import java.util.ArrayList;
import java.util.List;

class CustomLinkedList {
    int data;
    CustomLinkedList next;

    CustomLinkedList(int data) {
        this.data = data;
    }

}

public class SortedLLToBST {
    public static void main(String[] args) {
        CustomLinkedList node = new CustomLinkedList(1);
        node.next = new CustomLinkedList(2);
        node.next.next = new CustomLinkedList(3);
        node.next.next.next = new CustomLinkedList(4);
        node.next.next.next.next = new CustomLinkedList(5);
        node.next.next.next.next.next = new CustomLinkedList(6);
        node.next.next.next.next.next.next = new CustomLinkedList(7);
        node.next.next.next.next.next.next.next = new CustomLinkedList(8);
        node.next.next.next.next.next.next.next.next = new CustomLinkedList(9);
        node.next.next.next.next.next.next.next.next.next = new CustomLinkedList(10);
        node.next.next.next.next.next.next.next.next.next.next = new CustomLinkedList(11);
        node.next.next.next.next.next.next.next.next.next.next.next = new CustomLinkedList(12);
        List<Integer> mylist = getArrayList(node);
        BST tree = createBSTFromArray(mylist, 0, mylist.size()-1);
        BSTIterator.inOrder(tree);
    }

    public static List<Integer> getArrayList(CustomLinkedList node) {
        if (node == null)
            return new ArrayList<>();
        List<Integer> mylist = new ArrayList<>();

        while (node != null) {
            mylist.add(node.data);
            node = node.next;
        }
        return mylist;
    }

    public static BST createBSTFromArray(List<Integer> mylist, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        BST node = new BST(mylist.get(mid));
        if (start == end)
            return node;
        node.left = createBSTFromArray(mylist, start, mid - 1);
        node.right = createBSTFromArray(mylist, mid + 1, end);
        return node;
    }
}
