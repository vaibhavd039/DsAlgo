package traversal;

//Replace each node in binary tree with the sum of its inorder predecessor and successor

import base.BinaryTree;
import base.BinaryTreeBuilder;
import base.BinaryTreeIterator;

//Use inorder traversal and keep previous node and value of previous node’s  previous.
//        Update previous node with current node + previous value
public class ReplaceNodeWithSumPreAndSuc {
    static BinaryTree prevNode;
    static int prevValue;

    public static void main(String[] args) {
        BinaryTree node = BinaryTreeBuilder.buildBasicBinaryTree();
        BinaryTreeIterator.inOrderTraversal(node);
        System.out.print("\n");
        modifyThree(node);
        BinaryTreeIterator.inOrderTraversal(node);
    }


    public static void modifyThree(BinaryTree root) {
        if (root == null)
            return;
        modifyThree(root.left);
        if (prevNode == null) {
            prevNode = root;
            prevValue = 0;
        } else {
            int tempValue = prevNode.data;
            prevNode.data = prevValue + root.data;
            prevNode=root;
            prevValue=tempValue;
        }
        modifyThree(root.right);
    }
}
