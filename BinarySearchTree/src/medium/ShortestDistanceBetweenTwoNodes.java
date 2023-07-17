package medium;

import base.BST;
import base.BSTBuilder;

public class ShortestDistanceBetweenTwoNodes {
    public static void main(String[] args) {
        BST node = BSTBuilder.buildSampleBST();
        System.out.print(getDistance(node, 1, 5));
    }

    public static int getDistance(BST node, int a, int b) {
        if (node == null)
            return -1;
        BST lca = getLCA(node, a, b);
        if (lca == null)
            return -1;
        int distance1 = getDistanceFromlca(lca, a, 0);
        int distance2 = getDistanceFromlca(lca, b, 0);
        return distance1 + distance2;


    }

    public static int getDistanceFromlca(BST lca, int a, int distance) {
        if (lca.data == a)
            return distance;
        if (lca.data < a) {
            lca = lca.right;
            distance++;
            return getDistanceFromlca(lca, a, distance);
        } else {
            lca = lca.left;
            distance++;
            return getDistanceFromlca(lca, a, distance);
        }

    }

    public static BST getLCA(BST node, int a, int b) {
        if (node == null)
            return null;
        if (node.data > a && node.data > b) {
            return getLCA(node.left, a, b);
        } else if (node.data < a && node.data < b) {
            return getLCA(node.right, a, b);
        } else
            return node;
    }


}
