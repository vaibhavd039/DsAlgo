package intro;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeOperator {
    public static void deleteElement(BinaryTree root, int data){
        BinaryTree potentialNode =null;
        if(root==null)
            return;
        if(root.data==data && root.left==null && root.right==null){
            root=null;
                    return;
        }
        BinaryTree temp=null;
        Queue<BinaryTree> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            temp = queue.poll();
            if(temp==null)
                continue;
            if(temp.data==data){
                potentialNode=temp;
            }
            if(temp.left!=null && temp.left.data==data){
                potentialNode=temp.left;
            }
            if(temp.right!=null && temp.right.data==data){
                potentialNode=temp.right;
            }
            if(temp.left!=null) {
                queue.add(temp.left);
            }
            if(temp.right!=null) {
                queue.add(temp.right);
            }
        }
        if(potentialNode!=null){
           potentialNode.data=temp.data;
           temp.data=data;
            deleteTheDeepest(root, temp);
        }
    }

    private static void deleteTheDeepest(BinaryTree root,BinaryTree last){
        if(root==null || last==null){
            return ;
        }
        Queue<BinaryTree> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            BinaryTree temp =queue.poll();
            if(temp==null){
                continue;
            }
            if(temp.left==last){
                temp.left=null;
                break;
            }
            if(temp.right==last){
                temp.right=null;
                break;
            }
            queue.add(temp.left);
            queue.add(temp.right);
        }
    }

}
