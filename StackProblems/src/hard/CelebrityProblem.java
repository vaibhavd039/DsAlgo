package hard;

import java.util.Stack;

public class CelebrityProblem {
    public static void main(String[] args) {
        int MATRIX[][] =
                {{0, 0, 1, 0},
                        {0, 0, 1, 0},
                        {0, 1, 0, 0},
                        {0, 0, 1, 0}};
        System.out.print(getCelebrity(MATRIX));
    }

    public static int getCelebrity(int[][] mat) {
        int celeb = -1;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < mat.length; i++) {
            stack.push(i);
        }
        while (stack.size() > 1) {
            int a = stack.pop();
            int b = stack.pop();
            // Step 3 : Push the
            // remained person onto stack.
            if (knows(mat, a, b)) {
                stack.push(b);
            } else
                stack.push(a);
        }
        if (stack.empty())
            return -1;
        int c = stack.pop();
        for (int i = 0; i < mat.length; i++) {
            // If any person doesn't
            //  know 'c' or 'a' doesn't
            // know any person, return -1
            if (i != c && (knows(mat, c, i) || !knows(mat, i, c)))
                return -1;
        }
        return c;
    }

    static boolean knows(int[][] mat, int a, int b) {
        boolean res = (mat[a][b] == 1) ? true : false;
        return res;
    }

}
