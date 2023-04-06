package traversal;

import intro.BinaryTree;
import intro.BinaryTreeBuilder;
import intro.BinaryTreeIterator;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class ReverseLevelOrder {
    public static void main(String[] args) {
        BinaryTree root = BinaryTreeBuilder.buildBinaryTree(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9));
        BinaryTreeIterator.levelOrderTraversal(root);
        System.out.print("\n");
        printReverseLevelOrder(root);
    }

    public static void printReverseLevelOrder(BinaryTree root){
        Queue<BinaryTree> queue = new LinkedList<>();
        Stack<BinaryTree> st = new Stack<>();
        queue.add(root);
        while(!queue.isEmpty()){
            BinaryTree temp = queue.poll();
            if(temp==null)
                continue;
            st.push(temp);
            queue.add(temp.right);
            queue.add(temp.left);
        }

        while(!st.isEmpty()){
            BinaryTree temp = st.pop();
            if(temp==null)
                continue;
            System.out.print(temp.data+"\t");
        }
    }

}
