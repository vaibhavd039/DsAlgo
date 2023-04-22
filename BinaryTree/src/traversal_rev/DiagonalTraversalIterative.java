package traversal_rev;

import intro.BinaryTree;
import intro.BinaryTreeBuilder;
import intro.BinaryTreeIterator;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DiagonalTraversalIterative {
    public static void main(String [] args){
        BinaryTree node = BinaryTreeBuilder.buildBinaryTree(List.of(1,2,3,4,5,6,7,8,9));
        BinaryTreeIterator.levelOrderTraversal(node);
        System.out.print("\n");
        diagonalTraversal(node);
    }

    public static  void diagonalTraversal(BinaryTree node){
        Queue<BinaryTree> queue = new LinkedList<>();
        queue.add(node);
        queue.add(null);
        while(!queue.isEmpty()){
            BinaryTree temp = queue.poll();
            if(temp==null){
                if(queue.isEmpty())
                    return;
                System.out.print("\n");
                queue.add(null);
            } else {
                while(temp!=null) {
                    System.out.print(temp.data + "\t");
                    if (temp.left != null)
                        queue.add(temp.left);
                    temp = temp.right;
                }
            }
        }
    }
}
