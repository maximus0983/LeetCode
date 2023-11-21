package leet;

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        String s1 = s.toLowerCase();
        String s2 = s1.replaceAll("[^a-z0-9]", "");
        for (int i = 0; i < s2.length() / 2; i++) {
            if (s2.charAt(i) != s2.charAt(s2.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new ValidPalindrome().isPalindrome("anamana"));
    }
}
