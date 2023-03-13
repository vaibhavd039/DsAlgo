package intro;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeBuilder {
    public static BinaryTree buildBinaryTree(List<Integer> mylist){
        int counter =0;
        Queue<BinaryTree> queue= new LinkedList<>();
        BinaryTree root = new BinaryTree(mylist.get(counter));
        queue.add(root);
        counter++;
        while(counter< mylist.size()){
            BinaryTree node = queue.poll();
            if(node==null)
                continue;
            if(node.left==null){
                node.left= new BinaryTree(mylist.get(counter));
                counter++;
                queue.add(node.left);
            }
            if(counter<mylist.size()){
                node.right= new BinaryTree(mylist.get(counter));
                counter++;
                queue.add(node.right);
            }
        }
        return root;
    }

    public static BinaryTree insertElement(BinaryTree root, int data) {
        BinaryTree newnode = new BinaryTree(data);
        Queue<BinaryTree> queue= new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            BinaryTree temp = queue.poll();
            if(temp==null){
                temp= newnode;
                break;
            }
            if(temp.left==null){
                temp.left = newnode;
                break;
            }
            if(temp.right==null){
                temp.right = newnode;
                break;
            }
            queue.add(temp.left);
            queue.add(temp.right);
        }
        return root;
    }
}
