package leet.seanPrashadList;

public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int currSum = 0;
        int sum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            currSum = Math.max(nums[i], currSum + nums[i]);
            sum = Math.max(currSum, sum);
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new MaximumSubarray().maxSubArray(
                new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}
        ));
    }
}
