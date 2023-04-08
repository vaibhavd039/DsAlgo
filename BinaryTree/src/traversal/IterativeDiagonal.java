package traversal;

import intro.BinaryTree;
import intro.BinaryTreeBuilder;

import java.awt.desktop.SystemEventListener;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class IterativeDiagonal {
    public static void main(String [] args) {
        BinaryTree node = BinaryTreeBuilder.buildBinaryTree(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20));
        printDiagonal(node);
    }

    public static void printDiagonal(BinaryTree node){
        BinaryTree curr = node;
        Queue<BinaryTree> queue= new LinkedList<>();
        while(!queue.isEmpty() || curr!=null){
            if(curr!=null){
                System.out.print(curr.data+"\t");
                if(curr.left!=null)
                    queue.add(curr.left);
                curr=curr.right;
            }
            else {
                System.out.print("\n");
                curr=queue.poll();
            }
        }
    }
}
