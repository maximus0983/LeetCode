package leet;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> first = new HashMap<>();
        Map<Character, Integer> second = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            first.compute(s.charAt(i), (k, v) -> v == null ? 1 : v + 1);
            second.compute(t.charAt(i), (k, v) -> v == null ? 1 : v + 1);
        }
        return first.equals(second);
    }

    public static void main(String[] args) {
        System.out.println(new ValidAnagram().isAnagram("a","c"));
    }
}
