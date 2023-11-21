package leet.seanPrashadList;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    List<List<Integer>> lists = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        return searchAllCombo(candidates, new ArrayList<>(), 0, target, 0);
    }

    private List<List<Integer>> searchAllCombo(int[] candidates, List<Integer> curr, int sum, int target, int index) {
        if (sum == target) {
            lists.add(new ArrayList<>(curr));
            curr.clear();
            return lists;
        }
        if (sum > target) {
            return lists;
        }

        for (int i = index; i < candidates.length; i++) {
            if (candidates[i] <= target && sum + candidates[i] <= target) {
                sum = sum + candidates[i];
                curr.add(candidates[i]);
                searchAllCombo(candidates, new ArrayList<>(curr), sum, target, i);
                curr.remove(curr.size() - 1);
                sum = sum - candidates[i];
            }
        }
        return lists;
    }

    public static void main(String[] args) {
        System.out.println(new CombinationSum().combinationSum(
//                new int[]{2, 3, 6, 7}, 7
                new int[]{2, 3, 5}, 8
        ));
    }
}
