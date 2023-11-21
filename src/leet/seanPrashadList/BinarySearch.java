package leet.seanPrashadList;

public class BinarySearch {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (target == nums[mid]) {
                return mid;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else right = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        new BinarySearch().search(new int[]{-1, 0, 3, 5, 9, 12}, 9);
    }
}
