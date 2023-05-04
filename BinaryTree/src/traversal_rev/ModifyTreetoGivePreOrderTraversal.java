package traversal_rev;

import intro.BinaryTree;
import intro.BinaryTreeBuilder;

import java.util.List;

//Given a binary tree. Modify it in such a way that after
//        modification you can have a preorder traversal of it using only the right pointers.
//        During modification, you can use right as well as left pointers.

public class ModifyTreetoGivePreOrderTraversal {
    public static void main(String [] args){
        BinaryTree node = BinaryTreeBuilder.buildBinaryTree(List.of(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15));
    }

//    public void BinaryTree modifyTree(BinaryTree node){
//            if(node==null)
//                return;
//            BinaryTree curr = node;
//            BinaryTree predecessor =null;
//            while(node!=null){
//                if(curr.left==null){
//                    curr=curr.right;
//                } else {
//                    //find rightmost node
//                    predecessor=curr.left;
//                    while(predecessor.right!=null && predecessor.right!=curr){
//                        predecessor=predecessor.right;
//                    }
//
//                    if(predecessor.right==null){
//                        predecessor.right=curr;
//                        curr=curr.left;
//                    }
//                }
//            }
//    }

}
