package leet.seanPrashadList;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindAllDuplicatesinanArray {
    public List<Integer> findDuplicates(int[] nums) {
        Set<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        for (int n : nums) {
            boolean add = set.add(n);
            if (!add) {
                list.add(n);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(new FindAllDuplicatesinanArray().findDuplicates(
                new int[]{4, 3, 2, 7, 8, 2, 3, 1}
        ));
    }
}
