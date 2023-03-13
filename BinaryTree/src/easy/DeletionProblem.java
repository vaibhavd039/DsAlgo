package easy;

import intro.BinaryTree;
import intro.BinaryTreeBuilder;
import intro.BinaryTreeIterator;
import intro.BinaryTreeOperator;

import java.util.List;

public class DeletionProblem {
    public static void main(String [] args){
        BinaryTree root = BinaryTreeBuilder.buildBinaryTree(List.of(1,2,3,54,5,6,7,8,9));
        BinaryTreeBuilder.insertElement(root,12);
        BinaryTreeIterator.levelOrderTraversal(root);
        BinaryTreeOperator.deleteElement(root, 1);
        BinaryTreeIterator.levelOrderTraversal(root);
    }
}
