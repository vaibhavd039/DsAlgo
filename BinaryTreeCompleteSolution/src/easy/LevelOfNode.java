package easy;

import base.BinaryTree;
import base.BinaryTreeBuilder;

public class LevelOfNode {
    static int nodeLevel = -1;

    public static void main(String[] args) {
        BinaryTree node = BinaryTreeBuilder.buildBasicBinaryTree();
        int x = 8;
        getLevel(node
                , 0, x);
        System.out.print(nodeLevel);
    }

    public static void getLevel(BinaryTree node, int level, int x) {
        if (node == null) {
            return;
        }
        if (node.data == x) {
            nodeLevel = level;
        }
        level++;
        getLevel(node.left, level, x);
        getLevel(node.right, level, x);
    }
}
