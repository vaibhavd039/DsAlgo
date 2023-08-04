package easy;

public class CoinChange {
    public static void main(String[] args) {
        int[] coins ={2, 5, 3, 6};
        int sum = 10;
        System.out.print(count(coins, coins.length, 10));
    }

    static long count(int coins[], int n, int sum)
    {
        // table[i] will be storing the number of solutions for
        // value i. We need sum+1 rows as the table is
        // constructed in bottom up manner using the base case
        // (sum = 0)
        int table[] = new int[sum + 1];

        // Base case (If given value is 0)
        table[0] = 1;

        // Pick all coins one by one and update the table[]
        // values after the index greater than or equal to the
        // value of the picked coin
        for (int i = 0; i < n; i++)
            for (int j = coins[i]; j <= sum; j++)
                table[j] += table[j - coins[i]];

        return table[sum];
    }
}
