package traversal;

import base.BinaryTree;
import base.BinaryTreeBuilder;

import java.util.Stack;

public class IterativePostOrder {
    public static void main(String[] args) {
        BinaryTree node = BinaryTreeBuilder.buildBasicBinaryTree();
        iterativePostOrder(node);
    }

    public static void iterativePostOrder(BinaryTree node) {
        if (node == null) ;
        Stack<BinaryTree> stack1 = new Stack<>();
        Stack<BinaryTree> stack2 = new Stack<>();
        stack1.push(node);
        while (!stack1.isEmpty()) {
            BinaryTree temp = stack1.pop();
            if (temp == null)
                continue;
            stack1.push(temp.left);
            stack1.push(temp.right);
            stack2.push(temp);
        }
        while (!stack2.isEmpty()) {
            BinaryTree temp = stack2.pop();
            if(temp==null)
                continue;
            System.out.print(temp.data+"\t");
        }
    }

}
