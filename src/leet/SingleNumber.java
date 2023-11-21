package leet;

import java.util.HashSet;
import java.util.Set;

public class SingleNumber {
    public int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            if (set.contains(nums[i])) {
                set.remove(x);
            } else {
                set.add(x);
            }
        }
        return set.stream().findAny().get();
    }

    public static void main(String[] args) {
        System.out.println(new SingleNumber().singleNumber(
                new int[]{1,2,3,3,1}
        ));
    }
}
