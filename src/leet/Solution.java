package leet;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
//        int left = 0;
//        int right = nums.length - 1;
//        while (left < right) {
//            if (nums[right] > target || nums[left] + nums[right] > target) {
//                right--;
//            } else if (nums[left] + nums[right] < target) {
//                left++;
//            } else if (nums[left] + nums[right] == target){
//                return new int[]{left, right};
//            }
//        }
//        return new int[]{};
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            Integer y = map.get(target - nums[i]);
            if (y != null && i != y) {
                return new int[]{i, y};
            }
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().twoSum(new int[]{3, 2, 4}, 6)));
    }
}
