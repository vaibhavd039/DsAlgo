package traversal;

import base.BinaryTree;
import base.BinaryTreeBuilder;

import java.util.Stack;

public class IterativePreOrder {
    public static void main(String [] args){
        BinaryTree node = BinaryTreeBuilder.buildBasicBinaryTree();
        iterativePreOrder(node);
    }

    public static void iterativePreOrder(BinaryTree node){
        if(node==null)
            return;
        Stack<BinaryTree> stack = new Stack<>();
        stack.push(node);
        while(!stack.isEmpty()){
            BinaryTree temp = stack.pop();
            if(temp==null)
                continue;
            System.out.print(temp.data+"\t");
            stack.push(temp.right);
            stack.push(temp.left);
        }
    }
}
