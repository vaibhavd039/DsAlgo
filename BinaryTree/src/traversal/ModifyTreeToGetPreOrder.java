package traversal;

import intro.BinaryTree;
import intro.BinaryTreeBuilder;

import java.util.List;
import java.util.Stack;

public class ModifyTreeToGetPreOrder {
    public static void main(String [] args){
        BinaryTree node = BinaryTreeBuilder.buildBinaryTree(List.of(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20));
        printPreOrder(node);
    }

    public static void printPreOrder(BinaryTree root){
        modifyTree(root);
        while(root!=null){
            System.out.print(root.data+"\t");
            root= root.right;
        }
    }

    public static void modifyTree(BinaryTree node){
        Stack<BinaryTree> stack = new Stack<>();
        stack.push(node);
        BinaryTree pre=null;
        while(!stack.isEmpty()){
        BinaryTree temp =stack.pop();
        if(temp==null)
            continue;
        if(temp.right!=null){
            stack.push(temp.right);
        }
        if(temp.left!=null){
            stack.push(temp.left);
        }
        if(pre!=null){
            pre.right=temp;
        }
        pre=temp;
        }
    }
}
