package leet;

import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> m = new HashMap<>();
        int max = 0;
        char mostPop = s.charAt(0);
        int l = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            m.put(ch, m.getOrDefault(ch, 0) + 1);
            while (m.size() == k + 1) {
                max = Math.max(max, i - l + 1);
                m.put(ch, m.getOrDefault(ch, 0) - 1);
                if (m.get(ch) == 0) {
                    m.remove(ch);
                }
                l++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new LongestRepeatingCharacterReplacement().characterReplacement("ABAB", 2));
    }
}
