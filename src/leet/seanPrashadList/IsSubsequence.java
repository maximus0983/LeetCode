package leet.seanPrashadList;

public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        if (s.isEmpty() || t.isEmpty()) {
            return false;
        }
        int l = 0;
        for (int i = 0; i < t.length(); i++) {
            if (s.charAt(l) == t.charAt(i)) {
                l++;
            }
            if (l != 0 && l == s.length()) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new IsSubsequence().isSubsequence(
                "acb", "ahbgdc"
        ));
    }
}
