package leet;

public class BestTimetoBuyandSellStock {
    public int maxProfit(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        int left = prices.length - 2;
        int right = prices.length - 1;
        int profit = 0;
        while (left >= 0) {
            if (prices[right] > prices[left] && prices[right] - prices[left] > profit) {
                profit = Math.max(profit, prices[right] - prices[left]);
            } else if (prices[right] <= prices[left]) {
                right = left;
            }
            left--;
        }
        return Math.max(profit, 0);
    }

    public static void main(String[] args) {
        System.out.println(new BestTimetoBuyandSellStock().maxProfit(
                new int[]{7,1,5,3,6,4}
        ));
    }
}
