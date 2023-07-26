package traversal;

import base.BinaryTree;
import base.BinaryTreeBuilder;

import java.util.Stack;

public class SpiralLevelOrder {
    public static void main(String [] args ){
        BinaryTree node = BinaryTreeBuilder.buildBasicBinaryTree();
        getSpiralPrint(node);
    }


    public static  void getSpiralPrint(BinaryTree node){
        Stack<BinaryTree> stack1 = new Stack<>();
        Stack<BinaryTree> stack2 = new Stack<>();
        stack1.add(node);

        while(!stack1.isEmpty() || !stack2.isEmpty()){

            while(!stack1.isEmpty()){
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
