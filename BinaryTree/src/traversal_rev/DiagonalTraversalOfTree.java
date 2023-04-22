package traversal_rev;

import intro.BinaryTree;
import intro.BinaryTreeBuilder;
import intro.BinaryTreeIterator;

import java.util.*;

public class DiagonalTraversalOfTree {
    static Map<Integer, List<BinaryTree>> distanceMap = new HashMap<>();
    public static void main(String [] args){
        BinaryTree node = BinaryTreeBuilder.buildBinaryTree(List.of(1,2,3,4,5,6,7,8,9));
        BinaryTreeIterator.levelOrderTraversal(node);
        System.out.print("\n");
        diagonalTraversal(node, 0);

        distanceMap.entrySet().forEach(entry-> {
            entry.getValue().stream().forEach(binaryTree-> System.out.print(binaryTree.data+"\t"));
            System.out.print("\n");
        });
    }

    public static void diagonalTraversal(BinaryTree node, int distance){
        if(node==null)
            return;
        if(distanceMap.get(distance)==null) {
           distanceMap.put(distance, new ArrayList<>());
        }
        distanceMap.get(distance).add(node);
        diagonalTraversal(node.left, distance-1);
        diagonalTraversal(node.right, distance);
    }
}
