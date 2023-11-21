package leet;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqueCharacterinaString {
    public int firstUniqChar(String s) {
        char[] chars = s.toCharArray();
        int index = -1;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = s.length() - 1; i >= 0; i--) {
            map.compute(chars[i], (k, v) -> v == null ? 1 : v + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            if (map.get(chars[i]) == 1) {
                return i;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        System.out.println(new FirstUniqueCharacterinaString().firstUniqChar(
                "aabb"
        ));
    }
}
