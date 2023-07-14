package medium;

import base.BinaryTree;
import base.BinaryTreeBuilder;

public class DistanceBetweenTwoNodes {
    public static void main(String[] args) {
        BinaryTree node = BinaryTreeBuilder.buildBasicBinaryTree();
        BinaryTree lca = findLCA(node, 4, 18);
        int distance1 = getDistanceFromRoot(node, 4, 1);
        int distance2 = getDistanceFromRoot(node, 18, 1);
        int lcaDistance = getDistanceFromRoot(node, lca.data,1);
        System.out.print(distance1+distance2 -(2*lcaDistance));
    }

    public static BinaryTree findLCA(BinaryTree node, int a, int b){
        if(node==null){
            return  null;
        }
        if(node.data==a || node.data==b)
            return node;
        BinaryTree leftLCA = findLCA(node.left, a ,b);
        BinaryTree rightLCA = findLCA(node.right, a ,b);

        if(leftLCA!=null && rightLCA!=null){
            return node;
        }
        return  leftLCA!=null?leftLCA:rightLCA;
    }

    public static int getDistanceFromRoot(BinaryTree node, int a, int distance) {
        if (node == null)
            return -1;
        if (node.data == a) {
            return distance;
        }
        distance++;
        int left = getDistanceFromRoot(node.left, a, distance);
        int right = getDistanceFromRoot(node.right, a, distance);
        if (left != -1) {
            return left;
        } if (right != -1) {
            return right;
        }
        return -1;
    }
}

