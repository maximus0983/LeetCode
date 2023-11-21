package leet.seanPrashadList;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PermutationsII {
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> list = IntStream.of(nums).boxed().collect(Collectors.toCollection(ArrayList::new));
        return findAll(new ArrayList<>(), list, 0);
    }

    private List<List<Integer>> findAll(List<List<Integer>> lists, List<Integer> nums, int index) {
        if (index == nums.size()) {
            if (!lists.contains(nums)) {
                lists.add(nums);
            }
            return lists;
        }
        for (int i = index; i < nums.size(); i++) {
            swap(nums, index, i);
            findAll(lists, new ArrayList<>(nums), index + 1);
        }
        return lists;
    }

    private void swap(List<Integer> nums, int i, int j) {
        int tmp = nums.get(i);
        nums.set(i, nums.get(j));
        nums.set(j, tmp);
    }

    public static void main(String[] args) {
        System.out.println(new PermutationsII().permute(
                new int[]{1, 1, 3}
        ));
    }
}
