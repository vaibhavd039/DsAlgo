package traversal;

import intro.BinaryTree;
import intro.BinaryTreeBuilder;
import intro.BinaryTreeIterator;

import java.util.List;
import java.util.Stack;

public class InorderWithoutRecursion {
    public static  void main(String [] args){
        BinaryTree root = BinaryTreeBuilder.buildBinaryTree(List.of(1,2,3,4,65,6,7,9,1,2));
        BinaryTreeIterator.inorderTraversal(root);
        System.out.print("\n");
        printInOrderWithoutStack(root);
    }

    public static void printInOrderWithoutStack(BinaryTree root){
        BinaryTree curr=root;
        if(root==null)
            return;
         Stack<BinaryTree> stack = new Stack<>();
         while (curr!=null || stack.size()>0){
                while(curr!=null){
                    stack.push(curr);
                    curr= curr.left;
                }
                curr= stack.pop();
                System.out.print(curr.data+"\t");
                curr=curr.right;
         }
    }

}
