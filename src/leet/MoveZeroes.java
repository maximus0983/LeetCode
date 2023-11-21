package leet;

import java.util.Arrays;

public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != 0) {
                nums[i] = nums[j];
                i++;
                if (i < j) {
                    nums[j] = 0;
                }
            }
        }
        Arrays.stream(nums).forEach(System.out::println);
    }

    public static void main(String[] args) {
        new MoveZeroes().moveZeroes(
                new int[]{1, 0, 0, 6, 5, 8, 0, 0, 3}
        );
    }
}
