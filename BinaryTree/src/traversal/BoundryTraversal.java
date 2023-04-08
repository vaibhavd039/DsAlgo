package traversal;

import intro.BinaryTree;
import intro.BinaryTreeBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class BoundryTraversal {
    static List<BinaryTree> boundaryNodes= new ArrayList<>();
    public static void main(String [] args){
        BinaryTree node = BinaryTreeBuilder.buildBinaryTree(List.of(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20));
        printBoundary(node);
    }

    public static void printBoundary(BinaryTree root){

        boundaryNodes.add(root);
        if(isLeafNode(root)){
            boundaryNodes.forEach(node->System.out.print(node.data+"\t"));
            return;
        }
        addleftbounday(root.left);
        addLeaves(root);
        addrightBoundary(root.right);
        boundaryNodes.forEach(node->System.out.print(node.data+"\t"));
    }
    public static void addleftbounday(BinaryTree node){
        while(node!=null){
            if(!isLeafNode(node)) {
                boundaryNodes.add(node);
            }
            if(node.left!=null){
                node=node.left;
            } else {
                node= node.right;
            }
        }
    }


    public static void addrightBoundary(BinaryTree node){
        Stack<BinaryTree> stack  = new Stack<>();
        while(node!=null){
            if(!isLeafNode(node)) {
                stack.push(node);
            }
            if(node.right!=null){
                node=node.right;
            } else {
                node= node.left;
            }
        }
        while(!stack.isEmpty()){
            BinaryTree temp = stack.pop();
            boundaryNodes.add(temp);
        }
    }

    public static void  addLeaves(BinaryTree node){
        if(node==null)
            return;
            if(isLeafNode(node)){
                boundaryNodes.add(node);
            }
        addLeaves(node.left);
        addLeaves(node.right);
    }

    public static boolean isLeafNode(BinaryTree node){
        return  node.left==null && node.right==null;
    }

}
