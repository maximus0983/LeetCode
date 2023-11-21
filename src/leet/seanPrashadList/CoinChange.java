package leet.seanPrashadList;

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int len = coins.length;
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < len; j++) {
                if (coins[j] <= i) {
                    int currCount = dp[i - coins[j]];
                    if (currCount != Integer.MAX_VALUE && currCount + 1 < dp[i]) {
                        dp[i] = currCount + 1;
                    }
                }
            }
        }
        if (dp[amount] == Integer.MAX_VALUE) {
            return -1;
        }
        return dp[amount];
    }


    public static void main(String[] args) {
        System.out.println(new CoinChange().coinChange(
//                new int[]{1, 5, 2}, 11
                new int[]{2}, 3
        ));
    }
}
