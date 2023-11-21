package leet;

import java.util.Stack;

public class RotateArray {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        Stack<Integer> stack = new Stack<>();
        for (int i = nums.length - 1; i >= nums.length - k; i--) {
            stack.push(nums[i]);
        }
        for (int i = nums.length - 1; i >= k; i--) {
            nums[i] = nums[i-k];
        }
        for (int i = 0; i < k; i++) {
            nums[i] = stack.pop();
        }
    }

    public static void main(String[] args) {
        new RotateArray().rotate(new int[]{1, 2, 3, 4, 5, 6, 7}, 3);
    }
}
