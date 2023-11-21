package leet.seanPrashadList;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        return findSubs(new ArrayList<>(), new ArrayList<>(), nums, 0);
    }

    private List<List<Integer>> findSubs(List<List<Integer>> res, ArrayList<Integer> output, int[] nums, int i) {
        if (i == nums.length) {
            res.add(output);
            return res;
        }
        findSubs(res, new ArrayList<>(output), nums, i + 1);
        output.add(nums[i]);
        findSubs(res, new ArrayList<>(output), nums, i + 1);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Subsets().subsets(
                new int[]{1,2,3}
        ));
    }
}