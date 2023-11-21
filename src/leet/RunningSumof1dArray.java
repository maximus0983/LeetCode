package leet;

import java.util.Arrays;

public class RunningSumof1dArray {
    public int[] runningSum(int[] nums) {
        int[] ints = new int[nums.length];
        ints[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            ints[i] = ints[i - 1] + nums[i];
        }
        return ints;
    }

    public static void main(String[] args) {
        int[] ints = new RunningSumof1dArray().runningSum(new int[]{1, 2, 3, 4});
        Arrays.stream(ints).forEach(System.out::println);
    }
}
