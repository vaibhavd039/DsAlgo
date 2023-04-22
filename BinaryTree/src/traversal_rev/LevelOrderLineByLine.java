package traversal_rev;

import intro.BinaryTree;
import intro.BinaryTreeBuilder;
import intro.BinaryTreeIterator;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderLineByLine {
    public static void main(String [] args){
        BinaryTree node = BinaryTreeBuilder.buildBinaryTree(List.of(1,2,3,4,5,6,7,8,9));
        levelOrderLineByLine(node);
    }

    public static void levelOrderLineByLine(BinaryTree node){
        if(node==null)
            return;
        Queue<BinaryTree> queue = new LinkedList<>();
        queue.add(node);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i =0;i<size;i++){
                BinaryTree temp = queue.poll();
                System.out.print(temp.data+"\t");
                if(temp.left!=null){
                    queue.add(temp.left);
                }
                if(temp.right!=null){
                    queue.add(temp.right);
                }
            }
            System.out.print("\n");
        }
    }
}
