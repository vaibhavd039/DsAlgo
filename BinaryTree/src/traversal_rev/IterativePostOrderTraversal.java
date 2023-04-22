package traversal_rev;

import intro.BinaryTree;
import intro.BinaryTreeBuilder;
import intro.BinaryTreeIterator;

import java.util.List;
import java.util.Stack;

public class IterativePostOrderTraversal {
    public static void main(String [] args){
        BinaryTree node = BinaryTreeBuilder.buildBinaryTree(List.of(1,2,3,4,5,6,7,8,9));
        BinaryTreeIterator.postOrderTraversal(node);
        System.out.print("\n");
        iterativePostOrderWithTwoStack(node);
        System.out.print("\n");
        iterativePostOrderWithOneStack(node);
    }

    public  static void iterativePostOrderWithTwoStack(BinaryTree node){
       if(node==null)
           return;
        Stack<BinaryTree> stack1 = new Stack<>();
        Stack<BinaryTree> stack2 = new Stack<>();
        stack1.push(node);
        while(!stack1.isEmpty()){
            BinaryTree temp = stack1.pop();
            if(temp==null)
                continue;
            stack2.push(temp);
            stack1.push(temp.left);
            stack1.push(temp.right);
        }

        while(!stack2.isEmpty()){
            BinaryTree temp= stack2.pop();
            System.out.print(temp.data+"\t");
        }
    }

    //Push directly root node two times while traversing to the left.
    // While popping if you find stack top() is same as root then go for root->right else print root.

    public static void iterativePostOrderWithOneStack( BinaryTree node){
        if(node==null)
            return;
        Stack<BinaryTree> stack = new Stack<>();
        while(true){
            while(node!=null){
                stack.push(node);
                stack.push(node);
                node=node.left;
            }

            if(stack.isEmpty())
                return;
            node = stack.pop();
            if(!stack.isEmpty() && stack.peek()==node){
                node=node.right;
            } else {
                System.out.print(node.data+"\t");
                node=null;
            }
        }

    }
}
