package leet.seanPrashadList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CombinationSumII {
    List<List<Integer>> lists = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        return searchAllCombo(candidates, target, 0, 0, new ArrayList<>());
    }

    private List<List<Integer>> searchAllCombo(int[] candidates, int target, int sum, int index, ArrayList<Integer> curr) {
        if (sum == target) {
            Collections.sort(curr);
            if (!lists.contains(curr)) {
                lists.add(curr);
            }
        }
        int prev = -1;
        for (int i = index; i < candidates.length; i++) {
            if (prev != candidates[i]) {
                if (candidates[i] <= target && sum + candidates[i] <= target) {
                    curr.add(candidates[i]);
                    sum += candidates[i];
                    searchAllCombo(candidates, target, sum, i + 1, new ArrayList<>(curr));
                    curr.remove(curr.size() - 1);
                    sum = sum - candidates[i];
                    prev = candidates[i];
                }
            }
        }
        return lists;
    }

    public static void main(String[] args) {
        System.out.println(new CombinationSumII().combinationSum2(
                new int[]{10, 1, 2, 7, 6, 1, 5}, 8
        ));
    }
}
