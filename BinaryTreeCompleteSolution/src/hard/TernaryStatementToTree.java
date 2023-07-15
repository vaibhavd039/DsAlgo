package hard;
//Convert Ternary Expression to a Binary Tree
//Given a string that contains ternary expressions. The expressions may be nested, task is convert the given ternary
// expression to a binary Tree.

//
//If we see Symbol ‘?’
//        then we add next character as the left child of root.
//        If we see Symbol ‘:’
//        then we add it as the right child of current root.

import base.BinaryTree;
import base.BinaryTreeIterator;

public class TernaryStatementToTree {
    static int index = 0;

    public static void main(String[] args) {
        String ternary = "10?15?40:32:21";
        BinaryTree node = createTree(ternary, ternary.length());
        BinaryTreeIterator.levelOrderTraversal(node);
    }

    public static BinaryTree createTree(String tree, int size) {
        if (index >= size)
            return null;
        int num = 0;
        while (index < size && Character.isDigit(tree.charAt(index))) {
            num = num * 10 + Character.getNumericValue(tree.charAt(index));
            index++;
        }

        BinaryTree node = new BinaryTree(num);
        if(index>=size){
            return node;
        }
        if (tree.charAt(index) == '?') {
            index++;
            node.left = createTree(tree, size);
        }
        if(index>=size){
            return node;
        }
        if (tree.charAt(index) == ':') {
            index++;
            node.right = createTree(tree, size);
        }
        return node;
    }
}
