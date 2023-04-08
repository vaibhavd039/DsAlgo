package traversal;

import intro.BinaryTree;
import intro.BinaryTreeBuilder;

import java.util.List;
import java.util.Stack;

public class IterativePostOrderWithOneStack {
    public static void main(String [] agrs){
        BinaryTree node = BinaryTreeBuilder.buildBinaryTree(List.of(1,2,3,4,5,6,7,8,9));
        postOrderSingleStack(node);
    }

    public static void postOrderSingleStack (BinaryTree root){
        if(root==null)
            return;
        Stack<BinaryTree> stack = new Stack<>();
        while(true) {
            while (root != null) {
                stack.push(root);
                stack.push(root);
                root = root.left;
            }
            if(stack.isEmpty())
                return;
            root=stack.pop();
            if(!stack.isEmpty() && stack.peek()==root){
                root=root.right;
             } else {
                System.out.print(root.data+"\t");
                root=null;
            }
            }
    }

}
