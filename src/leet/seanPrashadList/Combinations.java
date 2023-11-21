package leet.seanPrashadList;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    List<List<Integer>> lists = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        return findOut(n, k, 1, new ArrayList<>());
    }

    private List<List<Integer>> findOut(int n, int k, int index, ArrayList<Integer> objects) {
        if (objects.size() == k) {
            lists.add(objects);
        }
        for (int i = index; i <= n; i++) {
            if (objects.size() < k) {
                objects.add(i);
                findOut(n, k, i + 1, new ArrayList<>(objects));
                objects.remove(objects.size() - 1);
            }
        }
        return lists;
    }

    public static void main(String[] args) {
        System.out.println(new Combinations().combine(4, 2));
    }
}
