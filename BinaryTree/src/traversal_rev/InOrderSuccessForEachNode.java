package traversal_rev;

import java.awt.desktop.SystemEventListener;

class BinaryTreeCustom{
    int data;
    BinaryTreeCustom left;
    BinaryTreeCustom right;
    BinaryTreeCustom next;
    BinaryTreeCustom(int data){
        this.data = data;
    }
}

public class InOrderSuccessForEachNode {

    static BinaryTreeCustom temp=null;
    public static void main(String [] args){
        BinaryTreeCustom root = new BinaryTreeCustom(1);
        root.left =new BinaryTreeCustom(2);
        root.right =new BinaryTreeCustom(3);
        root.left.left =new BinaryTreeCustom(4);
        root.left.right =new BinaryTreeCustom(5);
        root.right.left =new BinaryTreeCustom(6);
        root.right.right =new BinaryTreeCustom(7);
        root.left.left.left =new BinaryTreeCustom(8);
        root.left.left.right =new BinaryTreeCustom(9);
        populateSuccessor(root);
        printInorderSuccesor(root);
    }

    public static void populateSuccessor(BinaryTreeCustom root){
    if(root==null)
        return;
        populateSuccessor(root.right);
        if(temp==null){
            root.next=null;
            temp=root;
        } else {
            root.next=temp;
            temp=root;
        }
        populateSuccessor(root.left);

    }

    public static void printInorderSuccesor(BinaryTreeCustom root){
        if(root==null)
                return;
        printInorderSuccesor(root.left);
        int nextdata=0;
        if(root.next!=null){
            nextdata=root.next.data;
        }
        System.out.println(root.data +"\t"+nextdata);
        printInorderSuccesor(root.right);
    }

}
