package medium;

import java.util.Stack;

class StockPrice {
    int price;
    int days;

    StockPrice(int price, int days) {
        this.price = price;
        this.days = days;
    }
}

public class StockSpan {
    public static void main(String[] args) {
        int[] arr = {100,80,60,70,75,85,100};
        int[] ans = getStockSpan(arr);
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + "\t");
        }
    }

    public static int[] getStockSpan(int[] arr) {
        int[] ans = new int[arr.length];
        Stack<StockPrice> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            int days = 1;
            while (!stack.isEmpty() && stack.peek().price < arr[i]) {
                StockPrice stock = stack.pop();
                days += stock.days;
            }
            ans[i] = days;
            stack.push(new StockPrice(arr[i], days));
        }
        return ans;
    }
}
