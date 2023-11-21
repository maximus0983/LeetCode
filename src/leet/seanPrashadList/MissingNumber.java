package leet.seanPrashadList;

public class MissingNumber {
    public int missingNumber(int[] nums) {
        int x = 0;
        for (int i = 1; i < nums.length + 1; i++) {
            x = x ^ i;
        }
        for (int i = 0; i < nums.length; i++) {
            x = x ^ nums[i];
        }
        return x;
    }

    public static void main(String[] args) {
        System.out.println(new MissingNumber().missingNumber(
                new int[]{0, 1}
        ));
    }
}
