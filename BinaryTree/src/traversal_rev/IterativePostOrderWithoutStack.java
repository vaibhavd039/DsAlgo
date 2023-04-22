package traversal_rev;

import intro.BinaryTree;
import intro.BinaryTreeBuilder;
import intro.BinaryTreeIterator;

import java.util.List;

public class IterativePostOrderWithoutStack {
    public static void main(String [] args){
        BinaryTree node = BinaryTreeBuilder.buildBinaryTree(List.of(1,2,3,4,5,6,7,8,9));
        BinaryTreeIterator.postOrderTraversal(node);
        System.out.print("\n");

    }

}
