package traversal;

import base.BinaryTree;
import base.BinaryTreeBuilder;

import java.util.Stack;

public class IterativePostOrderOneStack {
    public static void main(String[] args) {
        BinaryTree node = BinaryTreeBuilder.buildBasicBinaryTree();
        postOrderWithOneStack(node);
    }

    public static void postOrderWithOneStack(BinaryTree node) {
        if (node == null)
            return;
        Stack<BinaryTree> st = new Stack<>();
        while (true) {
            while (node != null) {
                st.push(node);
                st.push(node);
                node = node.left;
            }
            if (st.isEmpty())
                return;
            node = st.pop();

            if (!st.isEmpty() && node == st.peek()) {
                node = node.right;
            } else {
                System.out.print(node.data + "\t");
                node = null;
            }

        }
    }
}
