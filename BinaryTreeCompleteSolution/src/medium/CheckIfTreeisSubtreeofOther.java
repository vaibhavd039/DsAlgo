package medium;

import base.BinaryTree;
import base.BinaryTreeBuilder;

public class CheckIfTreeisSubtreeofOther {
    public static void main(String[] args) {
        BinaryTree node1 = BinaryTreeBuilder.buildBasicBinaryTree();
        BinaryTree node2 = BinaryTreeBuilder.buildBasicBinaryTree();
        node2.left=null;
        System.out.print(isSubtree(node1, node2));

    }

    public static boolean isSubtree(BinaryTree node1, BinaryTree node2){
        StringBuilder pre1 = new StringBuilder("");
        getPreOrderString(node1, pre1);
        StringBuilder pre2 = new StringBuilder("");
        getPreOrderString(node2, pre2);
        if(pre1.indexOf(pre2.toString())!=-1){
            return true;
        }
        return  false;
    }

    public static void getPreOrderString(BinaryTree node, StringBuilder inorder){
        if(node==null){
            inorder.append(",#");
            return;
        }
        inorder.append(", ").append(node.data);
        getPreOrderString(node.left, inorder);
        getPreOrderString(node.right, inorder);
    }


    
    
}
