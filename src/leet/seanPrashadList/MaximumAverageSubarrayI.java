package leet.seanPrashadList;

import leet.MaximumSubarray;

public class MaximumAverageSubarrayI {
    public double findMaxAverage(int[] nums, int k) {
        double max_avr = Integer.MAX_VALUE;
        double curr_avr = 0;
        for (int i = 0; i < k; i++) {
            curr_avr += nums[i];
        }
        max_avr = Math.max(curr_avr, max_avr);
        for (int i = k; i < nums.length; i++) {
            curr_avr = curr_avr - nums[i - k] + nums[i];
            max_avr = Math.max(curr_avr, max_avr);
        }
        return max_avr/k;
    }

    public static void main(String[] args) {
        System.out.println(new MaximumAverageSubarrayI().findMaxAverage(
                new int[]{1,12,-5,-6,50,3}, 4
        ));
    }
}
