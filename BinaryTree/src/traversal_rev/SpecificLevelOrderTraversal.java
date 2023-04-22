package traversal_rev;

import intro.BinaryTree;
import intro.BinaryTreeBuilder;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//Perfect Binary Tree Specific Level Order Traversal
public class SpecificLevelOrderTraversal {
    public static void main (String [] args){
        BinaryTree root = BinaryTreeBuilder.buildBinaryTree(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9,10,11,12,13,14,15));
        specificOrderTraversal(root);
    }

    public static void specificOrderTraversal(BinaryTree node){
        if(node==null)
            return;
        Queue<BinaryTree> queue = new LinkedList<>();
        System.out.println(node.data);
        queue.add(node.left);
        queue.add(node.right);
        while(!queue.isEmpty()){
                BinaryTree temp1= queue.poll();
                BinaryTree temp2= queue.poll();
                System.out.print(temp1.data+"\t"+temp2.data+"\t");
            if(temp1.left!=null){
                queue.add(temp1.left);
                queue.add(temp2.right);
                queue.add(temp1.right);
                queue.add(temp2.left);
            }
        }
        }
    }

