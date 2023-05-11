package medium;

import intro.BinaryTree;
import intro.BinaryTreeIterator;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ConstructCompleteBinaryTreeFromLinkedLIst {
    public static void main(String [] args ){
        List<Integer> treeList = List.of(1,2,3,4,5,6,7,8,9);
        BinaryTree node = buildTree(treeList);
        BinaryTreeIterator.levelOrderTraversal(node);
    }

    public static BinaryTree buildTree(List<Integer> treeList){
        int counter = 0;
        BinaryTree root =  new BinaryTree(treeList.get(0));
        counter++;
        Queue<BinaryTree> queue = new LinkedList<>();
        queue.add(root);
        while(counter< treeList.size()){
            BinaryTree node = queue.poll();
            BinaryTree left  = new BinaryTree(treeList.get(counter));
            counter++;
            queue.add(left);
            node.left=left;
            if(counter<treeList.size()){
                BinaryTree right  = new BinaryTree(treeList.get(counter));
                counter++;
                queue.add(right);
                node.right=right;
            }
        }
        return root;
    }
}
