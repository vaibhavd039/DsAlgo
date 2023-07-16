package easy;

import base.BST;
import base.BSTBuilder;

public class SecondLargestElement {
    public static void main(String[] args) {
        BST node = BSTBuilder.buildSampleBST();
       System.out.print(getSecondLargestElement(node));

    }

    public static int getSecondLargestElement(BST node) {
        if(node==null)
            return 0;
        BST parent =null;
        while(node.left!=null){
            parent=node;
            node=node.left;
        }
        if(node.right!=null){
            return node.right.data;
        } else {
            return  parent.data;
        }
    }
}
