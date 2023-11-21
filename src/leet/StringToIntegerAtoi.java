package leet;

public class StringToIntegerAtoi {
    public int myAtoi(String s) {
        if (s.equals("") || s.equals("+") || s.equals("-") || Character.isLetter(s.charAt(0))) {
            return 0;
        }
        long sum = 0;
        int i = 0;
        boolean ignoreFirstWspace = true;
        boolean ignoreFirstZero = true;
        boolean ignoreRestOfString = false;
        boolean signOrDigitInitialized = false;
        boolean zeroIgnoreInitialized = false;
        boolean isNegative = false;
        while (!ignoreRestOfString && i < s.length()) {
            char c = s.charAt(i);
            if (Character.isWhitespace(c) && ignoreFirstWspace) {
                i++;
            } else if (c == '0' && ignoreFirstZero) {
                ignoreFirstWspace = false;
                zeroIgnoreInitialized = true;
                i++;
            } else if ((c == '+' || c == '-') && !signOrDigitInitialized && !zeroIgnoreInitialized) {
                isNegative = c == '-';
                signOrDigitInitialized = true;
                ignoreFirstWspace = false;
                ignoreFirstZero = false;
                i++;
            } else if ((!ignoreFirstWspace || signOrDigitInitialized || !ignoreFirstZero || zeroIgnoreInitialized || c == '.') && !Character.isDigit(c) && sum == 0) {
                return 0;
            } else {
                ignoreFirstWspace = false;
                signOrDigitInitialized = true;
                ignoreFirstZero = false;
                if (!Character.isDigit(c) && sum != 0) {
                    if (c == '.') {
                        return clampToInt(sum, isNegative);
                    }
                    ignoreRestOfString = true;
                } else if (!Character.isDigit(c) && sum == 0) {
                    return 0;
                } else {
                    if (sum > Integer.MAX_VALUE || sum < Integer.MIN_VALUE) {
                        return clampToInt(sum, isNegative);
                    }
                    int x = Character.digit(c, 10);
                    sum = sum * 10 + x;
                    i++;
                }
            }
        }

        return clampToInt(sum, isNegative);
    }

    private int clampToInt(long sum, boolean isNegative) {
        int res;
        if (isNegative) {
            if (-sum <= Integer.MIN_VALUE) {
                res = Integer.MIN_VALUE;
            } else res = (int) -sum;
        } else {
            if (sum >= Integer.MAX_VALUE) {
                res = Integer.MAX_VALUE;
            } else res = (int) sum;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new StringToIntegerAtoi().myAtoi(" b11228552307"));
    }
}
