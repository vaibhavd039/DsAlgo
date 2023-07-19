package hard;

import java.util.List;

//Given an array of size n, the task is to find whether array can represent a BST with n levels.
//        Since levels are n, we construct a tree in the following manner.
//        Assuming a number X,
//
//        Number higher than X is on the right side
//        Number lower than X is on the left side.
public class CheckArrayPresentedInBST {
    public static void main(String[] args) {
        List<Integer> currList = List.of(1, 2, 3, 4, 5, 6,  7, 8, 9);
        System.out.print(checkIfCanBeNLevelBST(currList));

    }

    public static boolean checkIfCanBeNLevelBST(List<Integer> list) {
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;
        boolean flag = true;
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) > list.get(i - 1) && list.get(i) > min && list.get(i) < max) {
                min = list.get(i-1);
            } else if (list.get(i) < list.get(i - 1) && list.get(i) > min && list.get(i) < max) {
                max = list.get(i-1);
            } else {
                flag = false;
                return flag;
            }
        }
        return flag;
    }
}
