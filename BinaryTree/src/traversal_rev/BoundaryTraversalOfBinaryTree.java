package traversal_rev;

import intro.BinaryTree;
import intro.BinaryTreeBuilder;


//approach is
// pehele left ki boundary banao
// right ki boundary banao
// sare leaf collect kr lo

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BoundaryTraversalOfBinaryTree {
    public static void main(String [] args){
        BinaryTree node = BinaryTreeBuilder.buildBinaryTree(List.of(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15));
        List<BinaryTree> boundary = new ArrayList<>();
        boundary.add(node);
        boundary.addAll(buildLeftBoundary(node.left));
        boundary.addAll(buildLeaf(node));
        boundary.addAll(buildLeftBoundary(node.right));
        boundary.forEach(binaryTree->System.out.print(binaryTree.data+"\t"));

    }

    public static  List<BinaryTree> buildLeftBoundary(BinaryTree node){
        List<BinaryTree> left = new ArrayList<>();
        while(node.left!=null && !isLeaf(node)){
            left.add(node);
            node = node.left;
        }
        return left;
    }

    public static  List<BinaryTree> buildRightBoundary(BinaryTree node){
        List<BinaryTree> right = new ArrayList<>();
        while(node.right!=null && !isLeaf(node)){
            right.add(node);
            node = node.right;
        }
        return right;
    }

    public static List<BinaryTree> buildLeaf(BinaryTree node){
        List<BinaryTree> leaf = new ArrayList<>();
        Queue<BinaryTree> queue = new LinkedList<>();
        queue.add(node);
        while(!queue.isEmpty()){
            BinaryTree temp = queue.poll();
            if(temp==null)
                continue;
            if(isLeaf(temp)){
                leaf.add(temp);
            } else {
                queue.add(temp.left);
                queue.add(temp.right);
            }
        }
        return leaf;
    }

    public static boolean isLeaf(BinaryTree node){
        return  ( node!=null && node.left==null && node.right==null);
    }
}
