package easy_rev;

import intro.BinaryTree;
import intro.BinaryTreeBuilder;

import java.util.List;

public class DiameterOfBT {
    public static void main(String [] args){
        BinaryTree node = BinaryTreeBuilder.buildBinaryTree(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15
                , 16, 17, 18, 19, 20));
    }

    public static int getDiameter(BinaryTree node){
        int ans =0;
        if(node==null)
            return 0;
        BinaryTree prev=null;
        BinaryTree curr = node;
        while(curr!=null){
            if(curr.left==null){
                curr=curr.right;
            } else {
                prev = curr.left;
                while (prev != null || prev.right != curr) {
                    prev = prev.right;
                }

                if (prev.right == null) {
                    prev.right = curr;
                    curr=curr.left;
                } else {
                    prev.right=null;
                    int leftHeight = 0;
                    int rightHeight= 0;
                    BinaryTree temp = curr.left;
                    while(temp!=null){
                        leftHeight++;
                        temp = temp.right;
                    }
                    temp=curr.left;
                    while(temp!=null){
                        rightHeight++;
                        temp = temp.left;
                    }
                  ans = Math.max(ans, leftHeight+rightHeight+1);
                    curr= curr.right;
                }
            }
        }
    }
}
