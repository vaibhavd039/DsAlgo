package easy;

import base.BST;
import base.BSTBuilder;

import java.util.ArrayList;
import java.util.List;

public class CheckIfTwoTreesAreSame {
    static List<Integer> array1 = new ArrayList<>();
    static List<Integer> array2 = new ArrayList<>();

    public static void main(String[] args) {
        BST node1 = BSTBuilder.buildSampleBST();
        BST node2 = BSTBuilder.buildSampleBST();
        createInOrderList(node1, array1);
        createInOrderList(node2, array2);
        System.out.print(checkIfTwoArrayAreSame(array1, array2));

    }

    public static boolean checkIfTwoArrayAreSame(List<Integer> arr1, List<Integer> arr2) {
        if (arr1.size() != arr2.size())
            return false;
        for (int i = 0; i < arr1.size(); i++) {
            if (arr1.get(i) != arr2.get(i)) {
                return false;
            }
        }
        return true;
    }


    public static void createInOrderList(BST node, List<Integer> list) {
        if (node == null) {
            return;
        }
        createInOrderList(node.left, list);
        list.add(node.data);
        createInOrderList(node.right, list);
    }
}
