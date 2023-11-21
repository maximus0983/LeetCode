package leet.seanPrashadList;

public class FindtheDuplicateNumber {
    public int findDuplicate(int[] nums) {
        int l = nums[0];
        int h = nums[0];
        do {
            l = nums[l];
            h = nums[nums[h]];
        } while (l != h);

        l = nums[0];
        while (l != h) {
            l = nums[l];
            h = nums[h];
        }
        return l;
    }

    public static void main(String[] args) {
        System.out.println(new FindtheDuplicateNumber().findDuplicate(
                new int[]{1, 3, 4, 2, 2}
        ));
    }
}