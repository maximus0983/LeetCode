package leet;

public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int localMax = 0;
        int globalMax = Integer.MIN_VALUE;
        for (int num : nums) {
            localMax = Math.max(num, num + localMax);
            if (localMax > globalMax) {
                globalMax = localMax;
            }
        }
        return globalMax;
    }

    public static void main(String[] args) {
        System.out.println(new MaximumSubarray().maxSubArray(
                new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}
//                new int[]{-2, 1}
//                new int[]{-2, -3, -1}

        ));
    }
}
