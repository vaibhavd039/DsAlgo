package traversal_rev;

import intro.BinaryTree;
import intro.BinaryTreeBuilder;
import intro.BinaryTreeIterator;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class ReverseLevelOrderTraversa {
    public static void main(String [] args) {
        BinaryTree root = BinaryTreeBuilder.buildBinaryTree(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9));
        reverseLevelOrder(root);
    }

    public static void reverseLevelOrder(BinaryTree node){
        if(node==null)
            return;
        Stack<BinaryTree> stack = new Stack<>();
        Queue<BinaryTree> queue = new LinkedList<>();
        queue.add(node);
        while(!queue.isEmpty()){
            BinaryTree temp = queue.poll();
            if(temp==null)
                continue;
            stack.push(temp);
            queue.add(temp.right);
            queue.add(temp.left);
        }
        while(!stack.isEmpty()){
            BinaryTree temp = stack.pop();
            System.out.print(temp.data+"\t");
        }
    }
}
