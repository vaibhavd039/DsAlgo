package medium;

import intro.BinaryTree;
import intro.BinaryTreeIterator;

import java.util.ArrayList;
import java.util.List;

public class FindAllPossibleNodes {
    public static void main(String [] args){
        int [] inorderTraversal = {1,2,3,4,5,6,7,8,9};
        List<BinaryTree>  trees = getAllPossibleTree(inorderTraversal,0,inorderTraversal.length);
    }

    public static List<BinaryTree> getAllPossibleTree(int [] arr, int start, int end){
        List<BinaryTree> trees = new ArrayList<>();
        if(start>end){
            trees.add(null);
            return trees;
        }
        for(int i =start;i<end;i++){
            List<BinaryTree> left = getAllPossibleTree(arr, start, i-1);
            List<BinaryTree> right = getAllPossibleTree(arr, i+1, end);
            for(int j =0;j<left.size();j++){
                for(int k =0;k<right.size();k++){
                    BinaryTree root = new BinaryTree(arr[i]);
                    root.left = left.get(j);
                    root.right= right.get(k);
                    trees.add(root);
                }
            }
        }
        return trees;
    }
}
