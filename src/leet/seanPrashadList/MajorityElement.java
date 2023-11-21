package leet.seanPrashadList;

public class MajorityElement {
    public int majorityElement(int[] nums) {
        int candidate = -1;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                candidate = nums[i];
                count++;
            } else {
                if (nums[i] == candidate) {
                    count++;
                } else {
                    count--;
                }
            }
        }
        return candidate;
    }

    private void quickSort(int[] nums, int l, int r) {
        if (l < r) {
            int p = partition(nums, l, r);
            quickSort(nums, l, p - 1);
            quickSort(nums, p + 1, r);
        }
    }

    private int partition(int[] nums, int l, int r) {
        int x = nums[r];
        int i = l - 1;
        for (int j = l; j < r; j++) {
            if (nums[j] < x) {
                i++;
                swap(nums,i, j);
            }
        }
        swap(nums, i + 1, r);
        return i + 1;
    }

    private void swap(int[] nums, int l, int r) {
        int num = nums[l];
        nums[l] = nums[r];
        nums[r] = num;
    }

    public static void main(String[] args) {
        System.out.println(new MajorityElement().majorityElement(
                new int[]{3, 3, 4}
        ));
    }
}
