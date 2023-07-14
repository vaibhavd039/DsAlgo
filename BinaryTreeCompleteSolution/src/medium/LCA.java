package medium;

import base.BinaryTree;
import base.BinaryTreeBuilder;

public class LCA {
    public static void main(String [] args){
        BinaryTree node = BinaryTreeBuilder.buildBasicBinaryTree();
        BinaryTree lca = findLCA(node, 18,11);
        System.out.print(lca.data);
    }

    public static BinaryTree findLCA(BinaryTree node, int a, int b){
        if(node==null){
            return  null;
        }
        if(node.data==a || node.data==b)
            return node;
        BinaryTree leftLCA = findLCA(node.left, a ,b);
        BinaryTree rightLCA = findLCA(node.right, a ,b);

        if(leftLCA!=null && rightLCA!=null){
            return node;
        }
        return  leftLCA!=null?leftLCA:rightLCA;
    }
}
