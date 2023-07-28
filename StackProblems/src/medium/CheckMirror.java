package medium;

import java.util.*;

public class CheckMirror {
    public static void main(String[] args) {
        int n = 3;
        int e = 2;
        int A[] = {1, 2, 1, 3};
        int B[] = {1, 3, 1, 2};
        System.out.print(isMirror(n, e, A, B));
    }

    public static boolean isMirror(int n, int e, int[] arr, int[] brr) {
        List<Stack<Integer>> s = new ArrayList<>();
        List<Queue<Integer>> q = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            s.add(new Stack<>());
            Queue<Integer> queue = new LinkedList<>();
            q.add(queue);
        }

        for (int i = 0; i < 2 * e; i += 2) {
            s.get(arr[i]).push(arr[i + 1]);
            q.get(brr[i]).add(brr[i + 1]);
        }

        for (int i = 1; i <= n; i++) {
            while (!s.get(i).isEmpty() && !q.get(i).isEmpty()) {
                int a = s.get(i).pop();
                int b = q.get(i).poll();

                if (a != b) {
                    return false;
                }
            }
        }
        return true;
    }

}
