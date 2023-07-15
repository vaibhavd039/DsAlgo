package hard;

import base.BinaryTree;
import base.BinaryTreeIterator;

public class TreeFromStringWithBracket {
    static int start=0;
    public static void main(String[] args) {
        String tree = "4(2(3)(1))(6(5))";
        BinaryTree node = createTree(tree);
        BinaryTreeIterator.levelOrderTraversal(node);
    }

    public static BinaryTree createTree(String tree) {

        if(start>tree.length()){
            return null;
        }
        int num=0;
        while(start<tree.length() && Character.isDigit(tree.charAt(start))){
            num =num*10+Character.getNumericValue(tree.charAt(start));
            start++;
        }
        BinaryTree node = new BinaryTree(num);
        if(start>=tree.length())
            return node;
        if(start<tree.length() && tree.charAt(start)=='('){
            start++;
            node.left= createTree(tree);
        }

        if(start<tree.length() && tree.charAt(start)==')'){
            start++;
            return node;
        }

        if(start<tree.length() && tree.charAt(start)=='('){
            start++;
            node.right= createTree(tree);
        }

        if(start<tree.length() && tree.charAt(start)==')'){
            start++;
            return node;
        }
        return node;
    }
}
