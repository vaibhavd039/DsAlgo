package traversal;

import intro.BinaryTree;
import intro.BinaryTreeBuilder;
import intro.BinaryTreeIterator;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class PerfectBinaryTreeSOT {
    public static void main(String [] args){
        BinaryTree root = BinaryTreeBuilder.buildBinaryTree(List.of(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15));
        BinaryTreeIterator.levelOrderTraversal(root);
        System.out.print("\n");
        printSOT(root);
    }

    public static void printSOT(BinaryTree node){
        if(node==null)
            return;
        Queue<BinaryTree> queue = new LinkedList<>();
        Stack<BinaryTree> st = new Stack<>();
        st.push(node);
        queue.add(node.left);
        queue.add(node.right);
        while(!queue.isEmpty()){
            BinaryTree temp1= queue.poll();
            BinaryTree temp2 = queue.poll();
            st.add(temp2.left);
            st.add(temp1.right);
            st.add(temp2.right);
            st.add(temp1.left);
            if(temp1.left!=null){
                queue.add(temp1.right);
                queue.add(temp2.left);
                queue.add(temp1.left);
                queue.add(temp2.right);

            }
        }

        while(!st.isEmpty()){
            BinaryTree temp = st.pop();
            if(temp==null)
                continue;
            System.out.print(temp.data+"\t");
        }
    }

}
