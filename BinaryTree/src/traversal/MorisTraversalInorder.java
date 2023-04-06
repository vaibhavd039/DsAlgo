package traversal;

import intro.BinaryTree;
import intro.BinaryTreeBuilder;

import java.util.List;

public class MorisTraversalInorder {
    public static void main(String [] args){
        BinaryTree node = BinaryTreeBuilder.buildBinaryTree(List.of(1,2,3,4,5,6,7,8,9));
        morrisTraversal(node);
    }

    public static void morrisTraversal(BinaryTree node){
        if(node==null)
            return;
        BinaryTree current=null;
        BinaryTree pre=null;
        current=node;
        while(current!=null) {
            if (current.left == null) {
                System.out.print(current.data + "\t");
                current = current.right;
            } else {
                pre = current.left;

                //find right most child
                while (pre.right != null && pre.right != current) {
                    pre = pre.right;
                }

                if (pre.right == null) {
                    pre.right = current;
                    current = current.left;
                } else {
                    pre.right = null;
                    System.out.print(current.data + "\t");
                    current = current.right;
                }

            }
        }

    }

}
