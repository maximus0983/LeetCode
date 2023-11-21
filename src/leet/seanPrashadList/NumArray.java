package leet.seanPrashadList;

public class NumArray {
    private int[] nums;
    private int[] prefixSum;

    public NumArray(int[] nums) {
        this.nums = nums;
        prefixSum = new int[nums.length];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            prefixSum[i] = sum;
        }
    }

    public int sumRange(int left, int right) {
        if (left == right) {
            return nums[left];
        }
        int sum = left > 0 ? prefixSum[left - 1] : 0;
        return prefixSum[right] - sum;
    }

    public static void main(String[] args) {
        NumArray numArray = new NumArray(
//                new int[]{-2, 0, 3, -5, 2, -1}
                new int[]{1,4,-6}
        );
        System.out.println(numArray.sumRange(1, 2));
    }
}
