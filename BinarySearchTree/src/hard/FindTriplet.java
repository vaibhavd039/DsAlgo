package hard;

import base.BST;
import base.BinaryTreeToBSTBuilder;

import java.util.ArrayList;
import java.util.List;

public class FindTriplet {
    static List<Integer> mylist = new ArrayList<>();

    public static void main(String[] args) {
        BST node = BinaryTreeToBSTBuilder.buildSamplerBST();
        node.left.left.left.data=-18;
        System.out.print(findTriple(node));
    }

    public static boolean findTriple(BST node) {
        getInorderList(node);
        for (int i = 0; i < mylist.size(); i++) {
            int x = mylist.get(i);
            int sum = -1 * x;
            if (doesSumExists(sum)) {
                return true;
            }
        }
        return false;
    }

    public static void getInorderList(BST node) {
        if (node == null)
            return;
        getInorderList(node.left);
        mylist.add(node.data);
        getInorderList(node.right);
    }

    public static boolean doesSumExists(int sum) {
        int start = 0;
        int end = mylist.size() - 1;
        while (start <= end) {
            if (mylist.get(start) + mylist.get(end) == sum) {
                return true;
            } else if (mylist.get(start) + mylist.get(end) < sum) {
                start++;
            } else {
                end--;
            }
        }
        return false;
    }


}
