package base;

import java.util.ArrayList;
import java.util.List;

//Given a BST (Binary Search Tree) that may be unbalanced, convert it into a balanced BST that has minimum possible
// height.


//        Set The middle element of the array as root.
//        Recursively do the same for the left half and right half.
//        Get the middle of the left half and make it the left child of the root created in step 1.
//        Get the middle of the right half and make it the right child of the root created in step 1.
//        Print the preorder of the tree.

public class BalanceBST {
    static List<Integer> mylist;

    public static void main(String[] args) {
        mylist = new ArrayList<>();
        BST node = BSTBuilder.buildSampleBST();
        generateInorderList(node);
        BST node1 = generateBalancedBSTWithSortedArray(mylist, 0, mylist.size()-1);
        BSTIterator.inOrder(node1);
    }

    public static void generateInorderList(BST node) {
        if (node == null)
            return;

        generateInorderList(node.left);
        mylist.add(node.data);
        generateInorderList(node.right);
    }


    public static BST generateBalancedBSTWithSortedArray(List<Integer> arr, int start, int end ) {
        if(start>end)
            return null;
        if(start==end)
            return  new BST(arr.get(start));
        int mid = (start+end)/2;
        BST root = new BST(arr.get(mid));
        root.left=generateBalancedBSTWithSortedArray(arr, start, mid-1);
        root.right=generateBalancedBSTWithSortedArray(arr, mid+1, end);
        return root;
    }


}
