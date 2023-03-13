package traversal;

import intro.BinaryTree;
import intro.BinaryTreeBuilder;
import intro.BinaryTreeIterator;

import java.util.Arrays;
import java.util.List;

public class PrintPostOrderWithInOrderandPre {
    public static void main( String [] args){
        BinaryTree root = BinaryTreeBuilder.buildBinaryTree(List.of(1,2,3,4,65,6,7,9));
        int [] inorder={9,4,2,65,1,6,3,7};
//        BinaryTreeIterator.inorderTraversal(root);
//        System.out.print("\n");
        int [] preorder={1,2,4,9,65,3,6,7};
//        BinaryTreeIterator.preOrderTraversal(root);
//        System.out.print("\n");
        printBetter(inorder, preorder,0, inorder.length-1);
        System.out.print("\n");
        BinaryTreeIterator.postOrderTraversal(root);
        System.out.print("\n");
    }

    static int counter=0;
    public static void printBetter(int [] inorder, int [] preorder, int start, int end){
        if(start>end)
            return;
        int index = getIndex(inorder, preorder[counter++]);
        printBetter(inorder, preorder, start, index-1);
        printBetter(inorder, preorder, index+1, end);
        System.out.print(inorder[index]+"\t");
    }

    public static int getIndex(int [] inOrder, int key){
        for(int i =0;i<inOrder.length;i++){
            if(inOrder[i]==key)
                return i;
        }
        return -1;
    }

}
