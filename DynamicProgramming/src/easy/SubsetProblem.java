package easy;

import java.util.List;

public class SubsetProblem {
    static int [][] mat;
    public static void main(String[] args) {
        int sum =18;
        List<Integer> arr = List.of(1, 2, 3, 4, 7);
        mat = new int[arr.size()+1][sum+1];
        System.out.print(isSubSetAvailable(sum, arr.size(), arr));
    }

    public static boolean isSubSetAvailable(int sum, int n, List<Integer> arr) {
        if (sum == 0)
            return true;
        if (n == 0)
            return false;
        if (arr.get(n - 1) > sum) {
            return isSubSetAvailable(sum, n - 1, arr);
        }
        return isSubSetAvailable(sum, n - 1, arr) || isSubSetAvailable(sum - arr.get(n - 1), n - 1, arr);
    }
    public static int isSubSetAvailableDynamic(int sum, int n, List<Integer> arr) {
        return -1;
    }
}
