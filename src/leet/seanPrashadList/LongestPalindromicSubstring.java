package leet.seanPrashadList;

public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        int left = 0;
        int right = 0;
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        for (int i = 0; i < len - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                left = i;
                right = i + 1;
            }
        }
        int j = 0;
        for (int dif = 2; dif < len; dif++) {
            for (int i = 0; i < len - dif; i++) {
                j = i + dif;
                if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    left = i;
                    right = j;
                }
            }
        }

        return s.substring(left, right + 1);
    }

    public static void main(String[] args) {
        System.out.println(new LongestPalindromicSubstring().longestPalindrome(
                "abacd"
        ));
    }
}
