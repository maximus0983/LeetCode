package leet;

public class ClimbingStairs {
    public int climbStairs(int n) {
        if (n == 1 || n == 2) {
            return n;
        }
        int prevprev = 1;
        int prev = 2;
        int res = 0;
        for (int i = 3; i <= n; i++) {
            res = prev + prevprev;
            prevprev = prev;
            prev = res;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new ClimbingStairs().climbStairs(6));
    }
}
