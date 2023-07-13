package traversal;

import base.BinaryTree;
import base.BinaryTreeBuilder;
import base.BinaryTreeIterator;

public class InOrderWithMorris {
    public static void main(String[] args) {
        BinaryTree binaryTree = BinaryTreeBuilder.buildBasicBinaryTree();
        BinaryTreeIterator.inOrderTraversal(binaryTree);
        System.out.print("\n");
        morrisTraversal(binaryTree);

    }

    public static void morrisTraversal(BinaryTree node) {
        BinaryTree curr, temp;
        curr = node;
        while (curr != null) {
            // find right most node which will be predecessor in inorder traversal
            if (curr.left != null) {
                temp = curr.left;
                while (temp.right != null && temp.right != curr) {
                    temp = temp.right;
                }
                // so we have defined who is predecessor of current node
                // now do the same for next left node
                if(temp.right==null){
                    temp.right=curr;
                    curr=curr.left;
                }
                //
                else{
                    temp.right=null;
                    System.out.print(curr.data+"\t");
                    curr=curr.right;
                }
            } else {
                System.out.print(curr.data+"\t");
                curr=curr.right;
            }
        }
    }
}
