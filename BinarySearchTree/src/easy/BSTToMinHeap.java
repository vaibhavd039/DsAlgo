package easy;

//Convert BST to Min Heap

import base.BST;
import base.BSTBuilder;
import base.BSTIterator;

import java.util.ArrayList;
import java.util.List;

public class BSTToMinHeap {
    static List<Integer> inorder = new ArrayList<>();
    static int index=0;

    public static void main(String[] args) {
        BST node = BSTBuilder.buildSampleBST();
        generateInorder(node);
        generateMinHeap(node);
        BSTIterator.levelOrder(node);
    }

    public static void generateInorder(BST node) {
        if (node == null)
            return;
        generateInorder(node.left);
        inorder.add(node.data);
        generateInorder(node.right);
    }

    public static void generateMinHeap(BST node){
        if(node==null)
            return;
        node.data=inorder.get(index);
        index++;
        generateInorder(node.left);
        generateInorder(node.right);
    }
}
