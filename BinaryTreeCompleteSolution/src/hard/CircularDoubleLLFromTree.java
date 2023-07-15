package hard;

import base.BinaryTree;
import base.BinaryTreeBuilder;

class CircularDLL {
    public int data;
    public CircularDLL last, next;

    public CircularDLL(int data) {
        this.data = data;
    }
}

public class CircularDoubleLLFromTree {
    static  BinaryTree prev=null, head=null;
    public static void main(String[] args) {
        BinaryTree node = BinaryTreeBuilder.buildBasicBinaryTree();

    }

    public static void createDLL(BinaryTree node) {
        if(node==null)
            return ;
        createDLL(node.left);
        if(prev==null) {
            head = node;
        }else {
        node.left=prev;
        prev.right=node;
        }

        createDLL(node.right);
    }
}
