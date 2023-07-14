package easy;

import base.BinaryTree;
import base.BinaryTreeBuilder;

public class CheckIfCousins {

    public static void main(String[] args) {
        BinaryTree node = BinaryTreeBuilder.buildBasicBinaryTree();
        checkCousin(node, 4,2);
    }


    public static boolean isSiblings(BinaryTree node, int a, int b) {
        if (node == null)
            return false;
        if(node.left!=null&& node.right!=null) {
            if ((node.left.data == a && node.right.data == b) || (node.left.data == b && node.right.data == a)) {
                return true;
            }
        }
        return isSiblings(node.left, a, b) || isSiblings(node.right, a, b);
    }

    public static int getLevel(BinaryTree node, int x, int level) {
        if (node == null)
            return -1;
        if (node.data == x) {
            return level;
        }
        level++;
        int left = getLevel(node.left, x, level);
        if (left != -1)
            return left;
        return getLevel(node.right, x, level);
    }

    public static void checkCousin(BinaryTree node, int a , int b){
        int levelA = getLevel(node, a, 0);
        int levelB = getLevel(node, b, 0);
        if(levelB==levelA && !isSiblings(node, a , b)){
            System.out.print("YES");
        } else {
            System.out.print("NO");
        }
    }

}
