package leet;

public class Sqrt {
    public int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }
        int res = 0;
        long start = 1;
        long end = x / 2;
        while (start <= end) {
            long mid = (start + end) / 2;
            long sqr = mid * mid;
            if (sqr == x || (sqr < x && x - sqr < mid)) {
                return (int) mid;
            } else if (sqr < x) {
                start = mid + 1;
                res = (int) mid;
            } else end = mid - 1;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Sqrt().mySqrt(2147395599));
    }
}
