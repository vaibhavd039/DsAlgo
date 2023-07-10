package base;

public class BinaryTreeImplSample {
    public static void main(String [] args){
        BinaryTree node = BinaryTreeBuilder.buildBasicBinaryTree();
        BinaryTreeIterator.inOrderTraversal(node);
        System.out.print("\n");
        BinaryTreeIterator.preOrderTraversal(node);
        System.out.print("\n");
        BinaryTreeIterator.postOrderTraversal(node);
        System.out.print("\n");
        BinaryTreeIterator.levelOrderTraversal(node);
        System.out.print("\n");
        BinaryTreeOperator.insertElementInTree(node, 33);
        System.out.print("\n");
        BinaryTreeIterator.levelOrderTraversal(node);
        BinaryTreeOperator.deleteElementFromTree(node, 5);
        System.out.print("\n");
        BinaryTreeIterator.levelOrderTraversal(node);
    }

}
