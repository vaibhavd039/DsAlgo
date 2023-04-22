package traversal_rev;

import intro.BinaryTree;
import intro.BinaryTreeBuilder;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class SpecificTraversalBottomToTOp {
    public static void main (String [] args){
        BinaryTree root = BinaryTreeBuilder.buildBinaryTree(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9,10,11,12,13,14,15));
        bottomToTop(root);
    }

    public static void bottomToTop(BinaryTree node){
        if(node==null)
            return;
        Stack<BinaryTree> stack = new Stack<>();
        Queue<BinaryTree> queue = new LinkedList<>();
        stack.add(node);
        queue.add(node.left);
        queue.add(node.right);
        while(!queue.isEmpty()){
            BinaryTree first = queue.poll();
            BinaryTree second = queue.poll();

            stack.push(second);
            stack.push(first);

            if(first.left!=null){
                queue.add(first.right);
                queue.add(second.left);
                queue.add(first.left);
                queue.add(second.right);
            }
        }

        while(!stack.isEmpty()){
            BinaryTree temp =stack.pop();
            System.out.print(temp.data+"\t");
        }
    }
}
