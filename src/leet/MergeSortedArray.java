package leet;

import java.util.Arrays;

public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int pos1 = m - 1;
        int pos2 = n - 1;
        for (int i = nums1.length - 1; i >= 0; i--) {
            if (pos1 >= 0 && pos2 >= 0) {
                if (nums1[pos1] > nums2[pos2]) {
                    int x = nums1[pos1];
                    nums1[pos1] = nums1[i];
                    nums1[i] = x;
                    pos1--;
                } else {
                    int x = nums2[pos2];
                    nums2[pos2] = nums1[i];
                    nums1[i] = x;
                    pos2--;
                }
            } else if (pos2 >= 0) {
                nums1[i] = nums2[pos2];
                pos2--;
            }
        }
        Arrays.stream(nums1).forEach(System.out::println);
    }

    public static void main(String[] args) {
        new MergeSortedArray().merge(
                new int[]{1, 5, 6, 0, 0, 0}, 3,
                new int[]{1, 2, 3}, 3
        );
    }
}
