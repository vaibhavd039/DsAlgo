package hard;

import base.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MergeTwoBST {
    static List<Integer> mergedData = new ArrayList<>();

    public static void main(String[] args) {
        BST node1 = BSTBuilder.buildSampleBST();
        BinaryTree bt = BinaryTreeBuilder.buildBasicBinaryTree();
        BST node2 = BinaryTreeToBSTBuilder.buildSamplerBST(bt);
        mergeBST(node1, node2);
        mergedData.forEach(element->System.out.print(element+"\t"));
    }

    public static void mergeBST(BST node1, BST node2) {
        if (node1 == null && node2 == null)
            return ;
        Stack<BST> stack1 = new Stack<>();
        Stack<BST> stack2 = new Stack<>();
        while (!stack1.isEmpty() || !stack2.isEmpty() || node1 != null || node2 != null) {
            while (node1 != null) {
                stack1.push(node1);
                node1 = node1.left;
            }
            while (node2 != null) {
                stack2.push(node2);
                node2 = node2.left;
            }
            if (stack2.isEmpty() || (!stack1.isEmpty() && stack1.peek().data < stack2.peek().data)) {
                node1 = stack1.pop();
                mergedData.add(node1.data);
                node1 = node1.right;
            } else {
                node2 = stack2.pop();
                mergedData.add(node2.data);
                node2 = node2.right;
            }

        }
    }
}
