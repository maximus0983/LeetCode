package leet.seanPrashadList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        return findSubs(new ArrayList<>(), new ArrayList<>(), nums, 0);
    }

    private List<List<Integer>> findSubs(List<List<Integer>> res, ArrayList<Integer> output, int[] nums, int i) {
        if (i == nums.length) {
//            Collections.sort(output);
            if (!res.contains(output)) {
                res.add(output);
            }
            return res;
        }
        findSubs(res, new ArrayList<>(output), nums, i + 1);
        int newNumber = nums[i];
        int index = Collections.binarySearch(output, newNumber);
        if (index < 0) {
            index = -(index + 1);
        }
        output.add(index, nums[i]);
        findSubs(res, new ArrayList<>(output), nums, i + 1);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new SubsetsII().subsetsWithDup(
                new int[]{1, 2, 2}
        ));
    }
}
