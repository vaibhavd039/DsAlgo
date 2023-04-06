package traversal;

import intro.BinaryTree;
import intro.BinaryTreeBuilder;
import intro.BinaryTreeIterator;

import java.util.List;
import java.util.Stack;

public class SpiralLevelOrder {
    public static void main(String [] args){
        BinaryTree root = BinaryTreeBuilder.buildBinaryTree(List.of(1,2,3,4,5,6,7,8,9));
        BinaryTreeIterator.levelOrderTraversal(root);
        System.out.print("\n");
        spiralLevelOrder(root);
    }

    public static void spiralLevelOrder(BinaryTree node){
        Stack<BinaryTree> st1 = new Stack<>();
        Stack<BinaryTree> st2 = new Stack<>();
        st1.push(node);
        while(!st1.isEmpty() || !st2.isEmpty()){
            while(!st1.isEmpty()){
                BinaryTree temp = st1.pop();
                if(temp==null)
                    continue;
                System.out.print(temp.data+"\t");
                st2.push(temp.right);
                st2.push(temp.left);
            }
            System.out.print("\n");
            while(!st2.isEmpty()){
                BinaryTree temp = st2.pop();
                if(temp==null)
                    continue;
                System.out.print(temp.data+"\t");
                st1.push(temp.left);
                st1.push(temp.right);
            }
            System.out.print("\n");
        }
    }
}
