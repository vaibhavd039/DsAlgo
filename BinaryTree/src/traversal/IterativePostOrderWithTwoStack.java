package traversal;

import intro.BinaryTree;
import intro.BinaryTreeBuilder;
import java.util.List;
import java.util.Stack;

//The idea is to push reverse postorder traversal to a stack.

//
//1. Push root to first stack.
//        2. Loop while first stack is not empty
//        2.1 Pop a node from first stack and push it to second stack
//        2.2 Push left and right children of the popped node to first stack
//        3. Print contents of second stack

public class IterativePostOrderWithTwoStack {
    public static void main(String [] args){
        BinaryTree root = BinaryTreeBuilder.buildBinaryTree(List.of(1,2,3,4,5,6,7,8,9));
        postOrderWithTwoStack(root);

    }

    public static void postOrderWithTwoStack(BinaryTree root){
        Stack<BinaryTree> stack1 = new Stack<>();
        Stack<BinaryTree> stack2 = new Stack<>();
        stack1.push(root);
        while(!stack1.isEmpty()){
            BinaryTree node =  stack1.pop();
            if(node==null)
                continue;
            stack2.push(node);
            stack1.push(node.left);
            stack1.push(node.right);
        }

        while(!stack2.isEmpty()){
            BinaryTree temp = stack2.pop();
            if(temp==null)
                continue;
            System.out.print(temp.data+"\t");        }
    }
}
