package leet;

import java.util.Arrays;

public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int count = 0;
        int currentIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                count++;
            }
            if (nums[i] == val) {
                currentIndex = i;
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] != val) {
                        count++;
                        int x = nums[j];
                        nums[j] = nums[currentIndex];
                        nums[currentIndex] = x;
                        break;
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] ints = {0,1,2,2,3,0,4,2};
        int i = new RemoveElement().removeElement(ints, 2);
        Arrays.stream(ints).forEach(System.out::println);
        System.out.println("res :"+i);
    }
}
