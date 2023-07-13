package traversal;

import base.BinaryTree;
import base.BinaryTreeBuilder;

import java.util.*;

public class DiagonalBinaryTree {
    static Map<Integer, Set<BinaryTree>> depthToNodeMap;

    public static void main(String[] args) {
        depthToNodeMap = new TreeMap<>();
        BinaryTree node = BinaryTreeBuilder.buildBasicBinaryTree();
        printDiagonalTree(node, 0);
        for (Map.Entry<Integer, Set<BinaryTree>> entry : depthToNodeMap.entrySet()) {
            entry.getValue().forEach(value-> System.out.print(value.data+"\t"));
            System.out.print("\n");
        }

    }

    public static void printDiagonalTree(BinaryTree node, int slant) {
        if (node == null)
            return;
        Set<BinaryTree> nodes = depthToNodeMap.computeIfAbsent(slant, k -> new HashSet<>());
        nodes.add(node);
        depthToNodeMap.put(slant, nodes);
        printDiagonalTree(node.left, slant - 1);
        printDiagonalTree(node.right, slant + 1);
    }

}
