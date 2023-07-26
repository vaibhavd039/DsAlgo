package base;

public class BinaryTreeExample {
    public static void main(String [] args){
        BinaryTree root = BinaryTreeBuilder.buildBasicBinaryTree();
        BinaryTreeIterator.levelOrderTraversal(root);
    }
}
