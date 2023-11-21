package leet;

import java.util.Arrays;

public class RichestCustomerWealth {
    public int maximumWealth(int[][] accounts) {
        int wealth = 0;
        for (int i = 0; i < accounts.length; i++) {
            wealth = Math.max(wealth, calcWealth(accounts[i]));
        }
        return wealth;
    }

    private int calcWealth(int[] account) {
        return Arrays.stream(account).sum();
    }
}
