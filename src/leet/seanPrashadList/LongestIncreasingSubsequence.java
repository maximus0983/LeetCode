package leet.seanPrashadList;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = nums.length - 2; i >= 0; i--) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] < nums[j]) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
        }
        return dp[0];
    }


    public static void main(String[] args) {
        System.out.println(new LongestIncreasingSubsequence().lengthOfLIS(
                new int[]{10, 9, 2, 5, 3, 7, 101, 18}
        ));
    }
}
