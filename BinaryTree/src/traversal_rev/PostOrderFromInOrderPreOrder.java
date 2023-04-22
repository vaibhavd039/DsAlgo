package traversal_rev;

import intro.BinaryTree;
import intro.BinaryTreeBuilder;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PostOrderFromInOrderPreOrder {
    static Map<Integer, Integer> keyToIndexMap = new HashMap<>();
    static int preIndex = 0;
    public static void main(String [] args){
        int [] inorder = {8, 4, 9, 2, 5, 1, 6, 3, 7, };
        int [] preOrder = {1, 2, 4, 8, 9, 5, 3, 6, 7};
        int length = inorder.length;
        getIndexMap(inorder);
        printPostOrder(inorder, preOrder,0, length-1);
    }

    public static void printPostOrder(int [] inorder, int [] preOrder, int start, int end){

        if(start>end)
            return;
        int rootkey = preOrder[preIndex++];
        int rootIndex = keyToIndexMap.get(rootkey);
        printPostOrder(inorder, preOrder, start, rootIndex-1);
        printPostOrder(inorder, preOrder,rootIndex+1, end);
        System.out.print(rootkey+"\t");
    }

    public static void getIndexMap(int [] inOrder){
        keyToIndexMap =  IntStream.range(0, inOrder.length).boxed().collect(Collectors.toMap(idx-> inOrder[idx] ,idx-> idx));
    }
}
