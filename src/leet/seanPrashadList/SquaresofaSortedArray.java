package leet.seanPrashadList;

public class SquaresofaSortedArray {
    public int[] sortedSquares(int[] nums) {
        int[] res = new int[nums.length];
        if (nums == null) {
            return null;
        }
        int left = 0;
        int right = nums.length - 1;
        int i = nums.length - 1;
        while (left <= right) {
            int leftSq = nums[left] * nums[left];
            int rightSq = nums[right] * nums[right];
            if (leftSq > rightSq) {
                res[i] = leftSq;
                left++;
            } else {
                res[i] = rightSq;
                right--;
            }
            i--;
        }
        return res;
    }

    public static void main(String[] args) {
//        new SquaresofaSortedArray().sortedSquares(new int[]{-10000, -9999, -7, -5, 0, 0, 10000});
//        new SquaresofaSortedArray().sortedSquares(new int[]{-10000, -9999, -7, -5});
        new SquaresofaSortedArray().sortedSquares(new int[]{-4, -1, 0, 3, 10});
    }
}
