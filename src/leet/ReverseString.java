package leet;

public class ReverseString {
    public void reverseString(char[] s) {
        for (int i = 0; i < s.length/2; i++) {
            swap(s, i, s.length - 1 - i);
        }
    }

    private void swap(char[] s, int i, int mirrI) {
        if (s[i] == s[mirrI]) {
            return;
        }
        char temp = s[i];
        s[i] = s[mirrI];
        s[mirrI] = temp;
    }

    public static void main(String[] args) {
        new ReverseString().reverseString(
                new char[]{'x','a','m'}
                );
    }
}
