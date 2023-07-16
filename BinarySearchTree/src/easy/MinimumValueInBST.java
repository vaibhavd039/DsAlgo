package easy;

import base.BST;
import base.BSTBuilder;

public class MinimumValueInBST {
    public static void main(String[] args) {
        BST node = BSTBuilder.buildSampleBST();
        System.out.print(getMinValue(node)+"\n");
    }

    public static int getMinValue(BST node){
        if(node==null)
            return -1;
        while(node.left!=null){
                node=node.left;
        }
        return node.data;
    }
}
