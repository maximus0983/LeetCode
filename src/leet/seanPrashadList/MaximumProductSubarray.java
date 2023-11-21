package leet.seanPrashadList;

public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        int index = 0;
        int zeroIndex = 0;
        int zerocount = 0;
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0)
                zerocount++;
        }
        while (zerocount >= 0) {
            zerocount--;
            int count = 0;
            boolean nextZero = true;
            while (nextZero && zeroIndex < nums.length) {
                if (nums[zeroIndex] == 0) {
                    nextZero = false;
                }
                if (nums[zeroIndex] < 0) {
                    count++;
                }
                zeroIndex++;
            }
            int localMax = nums[index];
//            max = nums[index];
            int pos;
            for (int i = index+1; i < zeroIndex; i++) {
                if (count % 2 != 0 || count == 0)
                    pos = nums[i];
                else pos = Math.abs(nums[i]);
                localMax = Math.max(pos, pos * localMax);
                max = Math.max(max, localMax);
            }
            index = zeroIndex;
//            zeroIndex++;
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new MaximumProductSubarray().maxProduct(
                new int[]{-2, 0, 1, -1}
        ));
    }
}
