package leet;

import java.util.Arrays;
import java.util.stream.Stream;

public class RemoveDuplicatesfromSortedArray {
    public int removeDuplicates(int[] nums) {
        int current = nums[0];
        int count = 1;
        int currentIndex = 1;
        for (int i = 1; i < nums.length; i++) {
            if (current != nums[i]) {
                count++;
                current = nums[i];
                int x = nums[currentIndex];
                nums[currentIndex] = nums[i];
                nums[i] = x;
                currentIndex++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] ints = {1, 3, 1, 2, 3};
        new RemoveDuplicatesfromSortedArray().removeDuplicates(ints);
        Arrays.stream(ints).forEach(System.out::println);
    }
}
