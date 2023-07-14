package medium;

import base.BinaryTree;
import base.BinaryTreeBuilder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MinimumSwapToSortTree {
    static int minSwap = 0;
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        list = new ArrayList<>();
        BinaryTree node = BinaryTreeBuilder.buildBasicBinaryTree();
        intialiseArray(node);
        getMinSwap();
        System.out.print(minSwap);
    }

    public static void intialiseArray(BinaryTree node) {
        if (node == null)
            return;
        intialiseArray(node.left);
        list.add(node.data);
        intialiseArray(node.right);
    }

    public static int getMinSwap() {
        Map<Integer, Integer> map = IntStream.range(0, list.size()).boxed().collect(Collectors.toMap(list::get,
                i -> i));
        List<Integer> tempList = new ArrayList<>();
        tempList.addAll(list);
        Collections.sort(tempList);

        for (int i = 0; i < tempList.size(); i++) {
            int element = tempList.get(i);
            if (i == map.get(element)) {
                continue;
            } else {
                int actualNumber = tempList.get(i);
                int actualNumberIndex = map.get(actualNumber);
                list.add(actualNumber, i);
                list.add(element, actualNumberIndex);
                minSwap++;
            }
        }
        return minSwap;
    }
}
