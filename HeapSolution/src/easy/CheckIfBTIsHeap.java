package easy;

import java.util.LinkedList;
import java.util.Queue;

class BinaryTree {
    int data;
    BinaryTree left, right;

    BinaryTree(int data) {
        this.data = data;
    }
}

public class CheckIfBTIsHeap {
    public static void main(String[] args) {
        BinaryTree root = null;
        root = new BinaryTree(10);
        root.left = new BinaryTree(9);
        root.right = new BinaryTree(8);
        root.left.left = new BinaryTree(7);
        root.left.right = new BinaryTree(6);
        root.right.left = new BinaryTree(5);
        root.right.right = new BinaryTree(4);
        root.left.left.left = new BinaryTree(3);
        root.left.left.right = new BinaryTree(2);
        root.left.right.left = new BinaryTree(1);
        System.out.println(isHeap(root));
    }

    public static boolean isHeap(BinaryTree node) {
        if (node == null)
            return true;
        Queue<BinaryTree> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            BinaryTree temp = queue.poll();
            if(temp.left!=null){
                if(temp.left.data>temp.data){
                    return false;
                } else {
                    queue.add(temp.left);
                }
            }

            if(temp.right!=null){
                if(temp.right.data>temp.data){
                    return false;
                } else {
                    queue.add(temp.right);
                }
            }
        }

        return true;
    }

}
