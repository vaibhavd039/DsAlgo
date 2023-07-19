package hard;

import base.BST;
import base.BinaryTreeToBSTBuilder;

import java.util.ArrayList;
import java.util.List;

//We can use a Doubly Linked List to merge trees in place. Following are the steps.
//
//        Convert the given two Binary Search Trees into a doubly linked list in place
//        Merge the two sorted Linked Lists (Refer to this post for this step).
public class MergeTwoBalancedBST {
    public static void main(String[] args) {
        BST node1 = BinaryTreeToBSTBuilder.buildSamplerBST(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9));
        BST node2 = BinaryTreeToBSTBuilder.buildSamplerBST(List.of(11, 12, 13, 14, 15, 16, 17, 18, 19));
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        createListFromBST(node1, list1);
        createListFromBST(node2, list2);
        List<Integer> listfinal = mergeTwoLists(list1, list2);
        listfinal.forEach(element->System.out.print(element+ "\t"));
    }

    public static void createListFromBST(BST node, List<Integer> items) {
        if (node == null)
            return;
        createListFromBST(node.left, items);
        items.add(node.data);
        createListFromBST(node.right, items);
    }

    public static List<Integer> mergeTwoLists(List<Integer> list1, List<Integer> list2) {
        List<Integer> finalList = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < list1.size() && j < list2.size()) {
            if (list1.get(i) < list2.get(j)) {
                finalList.add(list1.get(i));
                i++;
            } else {
                finalList.add(list2.get(i));
                j++;
            }
        }

        while (j < list2.size()) {
            finalList.add(list2.get(j));
            j++;
        }
        while (i < list1.size()) {
            finalList.add(list1.get(i));
            i++;
        }

        return finalList;
    }
}
