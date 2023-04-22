package traversal_rev;

import intro.BinaryTree;
import intro.BinaryTreeBuilder;

import java.util.List;
import java.util.Stack;

public class InorderWithoutRecursion {
    public static void main(String [] args){
        BinaryTree root = BinaryTreeBuilder.buildBinaryTree(List.of(1,2,3,4,5,6,7,8,9));
        inOrderWithoutRecursion(root);

    }

    public static void inOrderWithoutRecursion(BinaryTree node){
        Stack<BinaryTree> stack = new Stack<>();
        while(node!=null || !stack.isEmpty()){
            while(node!=null){
                stack.push(node);
                node = node.left;
            }
            BinaryTree temp = stack.pop();
            System.out.print(temp.data+"\t");
            node = temp.right;
        }
    }

}
