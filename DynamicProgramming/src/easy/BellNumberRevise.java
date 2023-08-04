package easy;

public class BellNumberRevise {
    public static void main(String[] args) {
    System.out.print(getNumber(5));
    }

    public static int getNumber(int n) {
        int[][] bell = new int[n + 1][n + 1];
        bell[0][0] = 1;
        bell[1][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    bell[i][j] = bell[i - 1][i - 1];
                } else {
                    bell[i][j]= bell[i-1][j-1]+bell[i][j-1];
                }

            }

        }
        return bell[n][0];
    }
}
