package easy;

import base.BinaryTree;
import base.BinaryTreeBuilder;

public class SizeofTree {
    public static void main(String[] args) {
        BinaryTree node1 = BinaryTreeBuilder.buildBasicBinaryTree();
        System.out.print(getSizeoftree(node1));
    }

    public static int getSizeoftree(BinaryTree node) {
        if(node==null)
            return 0;
        return  getSizeoftree(node.left) + getSizeoftree(node.right)+1;
    }
}
