package leet;

import java.util.Arrays;

public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int high = nums.length - 1;
        int low = 0;
        int index;
        if (target < nums[0]) {
            return 0;
        } else if (target > nums[nums.length - 1]) {
            return nums.length;
        }
        while (low <= high) {
            index = (high + low) / 2;
            if (nums[index] == target
                    || index != 0 && nums[index - 1] < target && target < nums[index]) {
                return index;
            } else if (index != nums.length - 1 && nums[index] < target && target < nums[index + 1]) {
                return index + 1;
            } else if (nums[index] < target) {
                low = index + 1;
            } else if (nums[index] > target) {
                high = index - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] ints = {1, 3};
        int i = new SearchInsertPosition().searchInsert(ints, 2);
        Arrays.stream(ints).forEach(System.out::println);
        System.out.println("res :" + i);
    }
}
