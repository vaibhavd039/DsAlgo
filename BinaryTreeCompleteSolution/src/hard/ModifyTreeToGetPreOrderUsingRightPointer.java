package hard;

import base.BinaryTree;
import base.BinaryTreeBuilder;
import base.BinaryTreeIterator;

import java.util.Stack;

public class ModifyTreeToGetPreOrderUsingRightPointer {
    public static void main(String[] args) {
        BinaryTree node = BinaryTreeBuilder.buildBasicBinaryTree();
        BinaryTreeIterator.preOrderTraversal(node);
        modifyTree(node);
        System.out.print("\n modified \n");
        BinaryTree curr= node;

        System.out.print("\n");
        while(curr!=null){
            System.out.print(curr.data+"\t");
            curr=curr.right;
        }

    }

    public static void modifyTree(BinaryTree node){
        if(node==null)
            return;
        Stack<BinaryTree> stack = new Stack<>();
        stack.push(node);
        BinaryTree prev =null;
        while(!stack.isEmpty()){
            BinaryTree temp = stack.pop();
            if(temp.right!=null){
                stack.push(temp.right);
            }
            if(temp.left!=null){
                stack.push(temp.left);
            }
            if(prev!=null){
                prev.right=temp;
            }
            prev=node;
        }
    }
}
