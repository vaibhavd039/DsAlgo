package easy_rev;

// A tree can be folded if the left and right subtrees of the
// tree are structure-wise mirror images of each other.
// An empty tree is considered foldable.

import intro.BinaryTree;
import intro.BinaryTreeBuilder;

import java.util.List;

public class FoldableBinaryTree {
    public static void main(String [] args){
        BinaryTree node = BinaryTreeBuilder.buildBinaryTree(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15
                , 16, 17, 18, 19, 20));
        System.out.print(isFoldable(node.left, node.right));
    }

    public static boolean isFoldable(BinaryTree node1, BinaryTree node2){
        if(node1==null && node2 ==null)
            return true;
        if(node1==null || node2 ==null)
            return false;
        return (node1.data==node2.data) && isFoldable(node1.left,node2.right) && isFoldable(node1.right, node2.left);
    }
}
