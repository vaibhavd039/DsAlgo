package hard;

import base.BST;
import base.BSTBuilder;
import base.BinaryTree;
import base.BinaryTreeIterator;

import java.util.LinkedList;
import java.util.Queue;

class LinkedListNode {
    int data;
    LinkedListNode next;

    LinkedListNode(int data) {
        this.data = data;
    }
}

public class BSTToMinheap {
    static LinkedListNode head;
    public static void main(String[] args) {
        BST node = BSTBuilder.buildSampleBST();
        head = null;
        createLinkedList(node);
        BinaryTree vt= createMinHeap(head);
        BinaryTreeIterator.levelOrderTraversal(vt);
    }

    public static void createLinkedList(BST node) {
        if (node == null)
            return;
        createLinkedList(node.right);
        LinkedListNode newNode = new LinkedListNode(node.data);
        newNode.next = head;
        head = newNode;
        createLinkedList(node.left);

    }

    public static BinaryTree createMinHeap(LinkedListNode head) {
        if (head == null)
            return null;
        BinaryTree node = new BinaryTree(head.data);
        Queue<BinaryTree> queue = new LinkedList<>();
        head=head.next;
        queue.add(node);
        while (!queue.isEmpty() || head != null) {
            BinaryTree temp = queue.poll();
            temp.left= new BinaryTree(head.data);
            head=head.next;
            if(head==null){
                break;
            }
            temp.right= new BinaryTree(head.data);
            head=head.next;

            queue.add(temp.left);
            queue.add(temp.right);
        }
        return node;
    }
}
