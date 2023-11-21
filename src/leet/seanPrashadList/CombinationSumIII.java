package leet.seanPrashadList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CombinationSumIII {
    List<List<Integer>> lists = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        return searchAllCombo(k, n, 0, 1, new ArrayList<>());
    }

    private List<List<Integer>> searchAllCombo(int k, int n, int sum, int index, ArrayList<Integer> curr) {
        if (curr.size() == k) {
            if (sum == n) {
                Collections.sort(curr);
                if (!lists.contains(curr)) {
                    lists.add(curr);
                    return lists;
                }
            } else return lists;
        }

        for (int i = index; i < 10; i++) {
            if (sum + i <= n) {
                curr.add(i);
                sum += i;
                searchAllCombo(k, n, sum, i + 1, new ArrayList<>(curr));
                curr.remove(curr.size() - 1);
                sum = sum - i;
            }
        }
        return lists;
    }

    public static void main(String[] args) {
        System.out.println(new CombinationSumIII().combinationSum3(
                3, 9
        ));
    }
}
