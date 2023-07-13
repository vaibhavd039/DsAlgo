package traversal;

import base.BinaryTree;
import base.BinaryTreeBuilder;
import base.BinaryTreeIterator;
import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.List;

//The idea is to keep a track of the path from the root to that particular node upto
//        which the path is to be reversed and once we get that particular node we simply reverse the data of those nodes.
public class ReverseTreePath {
    public static void main(String[] args) {
        BinaryTree node = BinaryTreeBuilder.buildBasicBinaryTree();
        getReversePath(node, new ArrayList<>(), 0, 11);
        BinaryTreeIterator.inOrderTraversal(node);

    }

    public static void getReversePath(BinaryTree node , List<BinaryTree> path, int pathLen, int x){
        if(node==null)
            return;
        path.add(pathLen, node);
        pathLen++;
        if(node.data==x){
            int i =0;
            int j =pathLen-1;
            while(i<j){
                int temp = path.get(i).data;
                path.get(i).data= path.get(j).data;
                path.get(j).data= temp;
                i++;
                j--;
            }
        }
        if(node.left==null && node.right==null)
            return;
        getReversePath(node.left, path, pathLen, x);
        getReversePath(node.right, path, pathLen, x);
    }


}
