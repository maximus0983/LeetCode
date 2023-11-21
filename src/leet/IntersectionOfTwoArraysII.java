package leet;

import java.util.*;

public class IntersectionOfTwoArraysII {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>(nums1.length);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            map.compute(nums1[i], (k, v) -> v == null ? 1 : v + 1);
        }
        for (int i = 0; i < nums2.length; i++) {
            Set<Integer> set = map.keySet();
            if (set.contains(nums2[i]) && map.get(nums2[i]) > 0) {
                list.add(nums2[i]);
                map.computeIfPresent(nums2[i], (k, v) -> v - 1);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        new IntersectionOfTwoArraysII().intersect(
                new int[]{4, 9, 5},
                new int[]{9, 4, 9, 8, 4}
        );
    }
}
