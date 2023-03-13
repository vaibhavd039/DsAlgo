package intro;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeIterator {
    public static void inorderTraversal(BinaryTree node){
        if(node==null)
            return;
        inorderTraversal(node.left);
        System.out.print(node.data+"\t");
        inorderTraversal(node.right);
    }

    public static void postOrderTraversal(BinaryTree node){
        if(node==null)
            return;
        postOrderTraversal(node.left);
        postOrderTraversal(node.right);
        System.out.print(node.data+"\t");
    }

    public static void preOrderTraversal(BinaryTree node){
        if(node==null)
            return;
        System.out.print(node.data+"\t");
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);
    }

    public static void levelOrderTraversal(BinaryTree node){
        if(node==null)
            return;
        Queue<BinaryTree> queue = new LinkedList<>();
        queue.add(node);
        while(!queue.isEmpty()){
            BinaryTree temp = queue.poll();
            if(temp==null)
                continue;
            System.out.print(temp.data+"\t");
            queue.add(temp.left);
            queue.add(temp.right);
        }
        System.out.print("\n");
    }

}
