package hard;

import base.BinaryTree;
import base.BinaryTreeBuilder;
import base.BinaryTreeIterator;

//Remove all nodes which don’t lie in any path with sum>= k
//
//Given a binary tree, a complete path is defined as a path from root to a leaf. The sum of all nodes on that path is
// defined as the sum of that path.
//        Given a number K, you have to remove (prune the tree) all nodes which don’t lie in any path with sum>=k.
public class RemoveAllNodeForLesThanKSum {
    public static void main(String[] args) {
        BinaryTree node = BinaryTreeBuilder.buildBasicBinaryTree();
        prune(node, 25);
        BinaryTreeIterator.levelOrderTraversal(node);

    }

    public static BinaryTree prune(BinaryTree node, int sum) {
        if (node == null)
            return null;
        node.left = prune(node.left, sum - node.data);
        node.right = prune(node.right, sum - node.data);
        if (node.left == null && node.right == null) {
            if(sum>node.data){
                node=null;
            }
        }
        return node;
    }

}
