package leet;

public class BestTimetoBuyandSellStockII {
    public int maxProfit(int[] prices) {
        int profitSum = 0;
        for (int i = 1; i < prices.length - 1; i++) {
            if (prices[i - 1] < prices[i]) {
                profitSum = profitSum + prices[i] - prices[i - 1];
            }
        }
        return profitSum;
    }

    public static void main(String[] args) {
        System.out.println(new BestTimetoBuyandSellStockII().maxProfit(
//                new int[]{7, 1, 5, 3, 6, 4}
                new int[]{1, 2, 3, 4, 5}
        ));
    }
}
