package leet;

public class HouseRobber {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int prev = 0;
        int prevprev = 0;
        for (int i = 0; i < nums.length; i++) {
            int temp = prev;
            prev = Math.max(prevprev + nums[i], prev);
            prevprev = temp;
        }
        return prev;
    }

    public static void main(String[] args) {
        System.out.println(new HouseRobber().rob(
//                new int[]{1,2,3,1}
//                new int[]{2,7,9,3,1}
                new int[]{2,7,9,3,1}
        ));
    }
}
