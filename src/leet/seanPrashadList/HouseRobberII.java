package leet.seanPrashadList;

public class HouseRobberII {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int prevprev = 0;
        int prev = 0;
        for (int i = 0; i < nums.length-1; i++) {
            int temp = prev;
            prev = Math.max(prevprev + nums[i], prev);
            prevprev = temp;
        }
        int res = prev;
        prevprev = 0;
        prev = 0;
        for (int i = nums.length-1;i>0; i--) {
            int temp = prev;
            prev = Math.max(prevprev + nums[i], prev);
            prevprev = temp;
        }
        return Math.max(res, prev);
    }

    public static void main(String[] args) {
        System.out.println(new HouseRobberII().rob(
                new int[]{2, 3, 2}
        ));
    }
}
