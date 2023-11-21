package leet.seanPrashadList;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    List<List<String>> res = new ArrayList<>();

    public List<List<String>> partition(String s) {
        dfs(0, new ArrayList<>(), s);
        return res;
    }

    private void dfs(int start, List<String> cur, String s) {
        if (start >= s.length()) {
            res.add(cur);
        }
        for (int i = start; i < s.length(); i++) {
            if (isPalindrome(s, start, i)) {
                cur.add(s.substring(start, i + 1));
                dfs(i + 1, new ArrayList<>(cur), s);
                cur.remove(cur.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String substring, int start, int end) {
        while (start <= end) {
            if (substring.charAt(start) != substring.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new PalindromePartitioning().partition("aab"));
    }
}
