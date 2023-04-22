package traversal_rev;

import intro.BinaryTree;
import intro.BinaryTreeBuilder;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class LevelOrderDirectionChangeAfterTwoLevels {
    static int size =0;
    static int levelCounter=0;
    static boolean isLeftToRight = true;
    public static void main(String [] args){
        BinaryTree node = BinaryTreeBuilder.buildBinaryTree(List.of(1,2,3,4,5,6,7,8,9));
        levelOrderWithDirectionChangeAfterTwoLevels(node);
    }

    public static void levelOrderWithDirectionChangeAfterTwoLevels(BinaryTree node){
        if(node==null)
            return;
        Stack<BinaryTree> stack = new Stack<>();
        Queue<BinaryTree> queue = new LinkedList<>();
        queue.add(node);
        while(!queue.isEmpty() || !stack.isEmpty()){
            size = queue.size();
            for(int i =0;i<size;i++){
                BinaryTree temp = queue.poll();
                if(isLeftToRight){
                    System.out.print(temp.data+"\t");
                } else {
                    stack.push(temp);
                }

                if(temp.left!=null){
                    queue.add(temp.left);
                }
                if(temp.right!=null){
                    queue.add(temp.right);
                }
            }
            levelCounter++;
            if(!isLeftToRight){
                while(!stack.isEmpty()){
                 BinaryTree   temp = stack.pop();
                    System.out.print(temp.data+"\t");
                }
            }
            if(levelCounter%2==0){
                isLeftToRight=!isLeftToRight;
            }
            System.out.print("\n");
        }
    }
}
