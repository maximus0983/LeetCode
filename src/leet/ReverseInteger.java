package leet;

public class ReverseInteger {
    public int reverse(int x) {
        String s = String.valueOf(x);
        char[] chars;
        String minus=null;
        if (x >= 0) {
            chars = reverseString(s.toCharArray());
        } else {
             minus= s.substring(0, 1);
            chars = reverseString(s.substring(1).toCharArray());
        }
        s = String.valueOf(chars);
        if (minus != null) {
            s = minus + s;
        }
        int reverse;
        try {
            reverse = Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return 0;
        }
        return reverse;
    }

    private char[] reverseString(char[] chars) {
        for (int i = 0; i < chars.length / 2; i++) {
            swaps(chars, i, chars.length - 1 - i);
        }
        return chars;
    }

    private void swaps(char[] s, int i, int mirrI) {
        if (s[i] == s[mirrI]) {
            return;
        }
        char temp = s[i];
        s[i] = s[mirrI];
        s[mirrI] = temp;
    }

    public static void main(String[] args) {
//        System.out.println(new ReverseInteger().reverse(-12345));
//        System.out.println(Integer.MAX_VALUE);
        System.out.println(788%10);
    }
}
