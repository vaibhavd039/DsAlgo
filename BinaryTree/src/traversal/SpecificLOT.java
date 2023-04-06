package traversal;

import intro.BinaryTree;
import intro.BinaryTreeBuilder;
import intro.BinaryTreeIterator;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


// print nodes in level order but nodes should be from left and
//         right side alternatively.


// process two nodes at a time
// pehele ka left and second ka right

public class SpecificLOT {
    public static void main(String[] args) {
        BinaryTree root = BinaryTreeBuilder.buildBinaryTree(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15));
        BinaryTreeIterator.levelOrderTraversal(root);
        System.out.print("\n");
        specificLOT(root);
    }

    public static void specificLOT(BinaryTree node) {
        Queue<BinaryTree> myqueue = new LinkedList<>();
        if (node == null)
            return;
        System.out.print(node.data+"\t");
        myqueue.add(node.left);
        myqueue.add(node.right);
        while (!myqueue.isEmpty()) {
            BinaryTree temp1 = myqueue.poll();
            BinaryTree temp2 = myqueue.poll();
            if (temp1 == null)
                continue;
            System.out.print(temp1.data+"\t"+temp2.data+"\t");
            if(temp1.left!=null){
                myqueue.add(temp1.left);
                myqueue.add(temp2.right);
                myqueue.add(temp1.right);
                myqueue.add(temp2.left);
            }
        }

    }
}
