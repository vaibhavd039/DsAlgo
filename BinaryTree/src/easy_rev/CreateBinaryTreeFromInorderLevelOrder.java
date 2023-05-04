package easy_rev;

import intro.BinaryTree;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// first get the root index
// then try following
// levelOrder subset for leftSubtree and RightSubTree
public class CreateBinaryTreeFromInorderLevelOrder {
    static Map<Integer, Integer> keyValueMap;
    public static void main(String [] args){
        int [] inOrder ={4, 8, 10, 12, 14, 20, 22};
        int [] levelOrder = {20, 8, 22, 4, 12, 10, 14};
        keyValueMap= constructIndeMap(inOrder);
    }

    public static BinaryTree constructTree(int [] inOrder, int [] levelOrder, int start, int end){
        if(start>end)
            return null;

        int root = levelOrder[start];
        int rootIndex = keyValueMap.get(root);
        BinaryTree node= new BinaryTree(root);
        Set<Integer> leftSubtreeLevelOrderSet = new HashSet<>();
        Set<Integer> rightSubtreeLevelOrderSet = new HashSet<>();
        Set<Integer> leftSubtreeInorderSet  = Arrays.stream(Arrays.copyOfRange(inOrder, start, rootIndex-1)).boxed().collect(Collectors.toSet());
        Set<Integer> rightSubtreeInorderSet  =  Arrays.stream(Arrays.copyOfRange(inOrder, rootIndex+1, end)).boxed().collect(Collectors.toSet());
        Arrays.stream(levelOrder).boxed().forEach(element -> {
            if(leftSubtreeInorderSet.contains(element)){
                leftSubtreeLevelOrderSet.add(element);
            } else {
                rightSubtreeLevelOrderSet.add(element);
            }
        });
        int [] leftLevelOrder = new int[leftSubtreeLevelOrderSet.size()];
//        leftLevelOrder = leftSubtreeLevelOrderSet.toArray();
//        node.left = constructTree(Arrays.copyOfRange(inOrder, start, rootIndex-1),leftSubtreeLevelOrderSet.toArray(),  start, rootIndex-1);
//        node.right = constructTree(Arrays.copyOfRange(inOrder, rootIndex+1, end),leftSubtreeLevelOrderSet.toArray(),  rootIndex+1, end);
        return node;
    }

    public static Map<Integer, Integer> constructIndeMap(int [] inOrder){
        return IntStream.range(0, inOrder.length).boxed().collect(Collectors.toMap(idx->inOrder[idx],idx->idx));
    }


}
