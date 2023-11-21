package leet.seanPrashadList;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int longestSequenceLength = 0;
        for (int i : nums) {
            set.add(i);
        }
        for (int i : nums) {
            if (!set.contains(i - 1)) {
                int num = i;
                int currentSequence = 1;
                while (set.contains(num + 1)) {
                    num++;
                    currentSequence++;
                }
                longestSequenceLength = Math.max(currentSequence, longestSequenceLength);
            }
        }
        return longestSequenceLength;
    }
//    Map<Integer, Integer> parent = new HashMap<>();
//
//    public int longestConsecutive(int[] nums) {
//        makeSet(nums);
//        for (int x : nums) {
//            int more = find(x + 1);
//            int less = find(x - 1);
//            if (more != -1) {
//                unite(more, x);
//            }
//            if (less != -1) {
//                unite(less, x);
//            }
//        }
//        return 1;
//    }
//
//    private void makeSet(int[] nums) {
//        for (int i : nums) {
//            parent.put(i, i);
//        }
//    }
//
//    public int find(int x) {
//        if (parent.get(x) == null) {
//            return -1;
//        }
//        if (parent.get(x) == x) return x;
//        return find(parent.get(x));
//    }
//
//    public void unite(int a, int b) {
//        int x = find(a);
//        int y = find(b);
//        parent.put(x, y);
//    }

    public static void main(String[] args) {
        LongestConsecutiveSequence lcs = new LongestConsecutiveSequence();
        int[] nums = new int[]{100, 4, 200, 1, 3, 2};
        lcs.longestConsecutive(nums);
        for (int i : nums) {
//            System.out.println(lcs.find(i));
        }
    }
}
