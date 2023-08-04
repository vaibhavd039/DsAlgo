package easy;

public class BionomialCofficient {
    public static void main(String[] args) {
        System.out.println(getBionomialCofficient(5, 2));
        System.out.println(getBionomialCofficientDYnamic(5, 2));

    }

    public static int getBionomialCofficient(int n, int k) {
        if (k > n)
            return 0;
        if (k == 0)
            return 1;
        if (k == n)
            return 1;
        return getBionomialCofficient(n - 1, k - 1) + getBionomialCofficient(n - 1, k);
    }

    public static int getBionomialCofficientDYnamic(int n, int k) {
        int[][] mat = new int[n + 1][k + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= Math.min(i, k); j++) {
                if (j == 0 || j == i) {
                    mat[i][j] = 1;
                } else {
                    mat[i][j] = mat[i - 1][j - 1] + mat[i - 1][j];
                }
            }
        }
        return mat[n][k];
    }
}
