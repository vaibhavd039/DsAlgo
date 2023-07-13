package traversal;

import base.BinaryTree;
import base.BinaryTreeBuilder;
import base.BinaryTreeIterator;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SpecificLevelOrder {
    public static void main(String[] args) {
        BinaryTree node = BinaryTreeBuilder.buildBinaryTree(List.of(1,2,3,4,5,6,7));
        BinaryTreeIterator.levelOrderTraversal(node);
        System.out.print("\n");
        specificLevelOrder(node);
    }

    public static void specificLevelOrder(BinaryTree node) {
        if(node==null)
            return;
        System.out.println(node.data);
        Queue<BinaryTree> queue = new LinkedList<>();
        queue.add(node.left);
        queue.add(node.right);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i =0;i<size;i+=2){
                BinaryTree temp1= queue.poll();
                BinaryTree temp2 = queue.poll();
                if(temp1==null)
                    continue;
                System.out.print(temp1.data+"\t"+ temp2.data+'\t');
                queue.add(temp1.left);
                queue.add(temp2.right);
                queue.add(temp1.right);
                queue.add(temp2.left);
            }
            System.out.print("\n");
        }
    }
}
