package leet;

public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        return String.valueOf(x).equals(new StringBuilder().append(x).reverse().toString());
    }

    public static void main(String[] args) {
        System.out.println(new PalindromeNumber().isPalindrome(123321));
    }
}
