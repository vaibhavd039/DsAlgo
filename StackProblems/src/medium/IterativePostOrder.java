package medium;

import java.util.Stack;

class BinaryTree {
    int data;
    BinaryTree left, right;

    BinaryTree(int data) {
        this.data = data;
    }
}

public class IterativePostOrder {
    public static void main(String[] args) {
        BinaryTree root = new BinaryTree(1);
        root.left= new BinaryTree(2);
        root.right= new BinaryTree(3);
        root.left.left= new BinaryTree(4);
        root.left.right= new BinaryTree(5);
        root.right.left= new BinaryTree(6);
        root.right.right= new BinaryTree(7);
        postOrder(root);
    }

    public static void postOrder(BinaryTree root) {
        Stack<BinaryTree> stack1 = new Stack<>();
        Stack<BinaryTree> stack2 = new Stack<>();
        stack1.push(root);
        while (!stack1.isEmpty()) {
            BinaryTree temp = stack1.pop();
            stack2.push(temp);
            if (temp.left != null) {
                stack1.push(temp.left);
            }
            if (temp.right != null) {
                stack1.push(temp.right);
            }
        }
        while(!stack2.isEmpty()){
            System.out.println(stack2.pop().data);
        }
    }

}
