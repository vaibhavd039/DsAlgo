package traversal;

import intro.BinaryTree;
import intro.BinaryTreeBuilder;
import intro.BinaryTreeIterator;

import java.util.List;

////Given a Perfect Binary Tree, reverse the alternate level nodes of the binary tree.
//This method simply swaps the values of the children node, if the current node is on an even level. Because that ultimately swaps elements on an odd level.
public class ReverseAlternateLevels {
    public static void main(String [] args){
        BinaryTree root = BinaryTreeBuilder.buildBinaryTree(List.of(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15));
        swapOddLevels(root.left,root.right,0);
        BinaryTreeIterator.levelOrderTraversal(root);

    }

    public static  void swapOddLevels(BinaryTree node1, BinaryTree node2, int level){
        if(node1==null || node2==null)
            return;
        if(level%2==0){
            int data=node1.data;
            node1.data=node2.data;
            node2.data=data;
        }
        swapOddLevels(node1.left, node2.right, level+1);
        swapOddLevels(node1.right, node2.left, level+1);

    }

}
