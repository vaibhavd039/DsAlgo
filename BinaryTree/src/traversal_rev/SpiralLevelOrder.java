package traversal_rev;

import intro.BinaryTree;
import intro.BinaryTreeBuilder;

import java.util.List;
import java.util.Stack;

public class SpiralLevelOrder {
    public static void main(String [] args){
        BinaryTree node = BinaryTreeBuilder.buildBinaryTree(List.of(1,2,3,4,5,6,7,8,9));
        spiralLevelOrder(node);
    }

    public static void spiralLevelOrder(BinaryTree node){
        if(node==null)
            return;
        Stack<BinaryTree> stack1 = new Stack<>();
        Stack<BinaryTree> stack2 = new Stack<>();
        stack1.push(node);
        while(!stack1.isEmpty() || !stack2.isEmpty()){
            while(!stack1.isEmpty()) {
                BinaryTree temp = stack1.pop();
                if(temp==null)
                    continue;
                System.out.print(temp.data+"\t");
                stack2.push(temp.right);
                stack2.push(temp.left);
            }
            System.out.print("\n");

            while(!stack2.isEmpty()){
                BinaryTree temp = stack2.pop();
                if(temp==null)
                    continue;
                System.out.print(temp.data+"\t");
                stack1.push(temp.left);
                stack1.push(temp.right);
            }
            System.out.print("\n");
        }
    }
}
