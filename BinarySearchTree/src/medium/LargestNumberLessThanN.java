package medium;

import base.BST;
import base.BSTBuilder;

public class LargestNumberLessThanN {
    public static void main(String[] args) {
        BST node = BSTBuilder.buildSampleBST();
       int x =  getNumber(node, 25);
       System.out.print(x);
    }

    public static int getNumber(BST node, int x) {
        if (node == null)
            return -1;
        if(node.data==x)
            return x;
        if (node.data < x) {
            int right =  getNumber(node.right, x);
            if(right==-1){
                return node.data;
            } else
                return right;
        } else if (node.data > x) {
                return  getNumber(node.left, x);
        }
        return -1;
    }
}
