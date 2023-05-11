package medium;

import intro.BinaryTree;
import intro.BinaryTreeBuilder;

import java.util.List;

class DoublyLinkedList {
    int data;
    DoublyLinkedList prev, next;
    DoublyLinkedList(int data){
        this.data=data;
    }
}
public class BinaryTreeToDLL {
    static DoublyLinkedList tail, head;
    public static void main(String [] args){
        BinaryTree node = BinaryTreeBuilder.buildBinaryTree(List.of(1,2,3,4,5,6,7,8,9));
        head = buildDoublyLinkedlist(node);
        DoublyLinkedList pointer =head;
        while(pointer.prev!=null){
            pointer=pointer.prev;
        }
        while(head.next!=null){
            System.out.print(head.data+"\t");
            head=head.next;
        }

    }


    public static DoublyLinkedList buildDoublyLinkedlist(BinaryTree node){
        if(node ==null)
            return null;
        DoublyLinkedList left = buildDoublyLinkedlist(node.left);
        DoublyLinkedList head = new DoublyLinkedList(node.data);
        head.prev=left;
        DoublyLinkedList right =  buildDoublyLinkedlist(node.right);
        head.next=right;
        return head;
    }
}
