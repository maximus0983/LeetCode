package leet;

import java.util.HashMap;
import java.util.Map;

public class UniqeCharArray {
    static String getShortestUniqueSubstring(char[] arr, String str) {
        int l = 0;
        int r = 0;
        int count = arr.length;
        String ans = "";
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], 1);
        }
        String tmp = "";
        while (r < str.length()) {
            char x = str.charAt(r);
            if (map.containsKey(x)) {
                if (map.get(x) == 1) {
                    count--;
                }
                map.put(x, map.get(x) - 1);
            }

            while (count == 0 && l <= r) {
                if (ans == "" || ans.length() > r - l + 1) {
                    ans = str.substring(l, r + 1);
                }
                if (map.containsKey(str.charAt(l))) {
                    if (map.get(str.charAt(l)) == 0) {
                        count++;
                        tmp = str.substring(l, r + 1);
                    }
                    map.put(str.charAt(l), map.get(str.charAt(l)) + 1);
                }
                l++;
            }
            r++;
        }
        return ans;
        // your code goes here
    }

    public static void main(String[] args) {
        System.out.println(getShortestUniqueSubstring(new char[]{'A', 'B', 'C'}, "ADOBECODEBANCDDD"));
    }
}
