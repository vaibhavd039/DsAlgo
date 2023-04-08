package traversal;

import intro.BinaryTree;
import intro.BinaryTreeBuilder;

import java.awt.desktop.SystemEventListener;
import java.util.*;
//Problem statement
//Consider lines with a slope of -1 that cross through nodes. Print all diagonal elements in a binary tree that belong to the same line, given a binary tree.
//
//solution
//The plan is to make use of a map. Different slope distances are used in the map as a key

class CustomBinaryTree{
    public BinaryTree node;
    public  int level;
    CustomBinaryTree(BinaryTree node, int level){
        this.node =node;
        this.level=level;
    }

}
public class DiagonalTraversal {
    public static void main(String [] args){
        BinaryTree node = BinaryTreeBuilder.buildBinaryTree(List.of(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20));
        printDiagonal(node);
    }

    public static void printDiagonal(BinaryTree node){
        int level=0;
        Queue<CustomBinaryTree> queue = new LinkedList<>();
        Map<Integer, List<BinaryTree>> levelMap = new HashMap<>();
        queue.add(new CustomBinaryTree(node,level));

        while(!queue.isEmpty()){
            CustomBinaryTree temp = queue.poll();
            levelMap.putIfAbsent(temp.level, new ArrayList<>());
            levelMap.get(temp.level).add(temp.node);
            if(temp.node.right!=null){
                queue.add(new CustomBinaryTree(temp.node.right,temp.level));
            }
            if(temp.node.left!=null){
                queue.add(new CustomBinaryTree(temp.node.left,temp.level+1));
            }
        }

        for(int i =0;i<=levelMap.keySet().size();i++){
            List<BinaryTree> levellist = levelMap.get(i);
            if(levellist==null||levellist.isEmpty())
                continue;
            levellist.forEach(element->System.out.print(element.data+"\t"));
            System.out.print("\n");
        }
    }
}
