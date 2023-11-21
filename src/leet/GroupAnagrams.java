package leet;

import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList();
        Map<String, int[]> map = new HashMap();
        for (int i = 0; i < strs.length; i++) {
            List<String> list = new ArrayList();
            String s = strs[i];
            int[] arr = map.get(s);
            if (arr == null) {
                arr = createAr(s);
                map.put(s, arr);
            }
            if (!s.equals("-")) {
                list.add(s);
                for (int j = i + 1; j < strs.length; j++) {
                    if (!strs[j].equals("-")) {

                        int[] arr1 = map.get(strs[j]);
                        if (arr1 == null) {
                            arr1 = createAr(strs[j]);
                            map.put(strs[j], arr1);
                        }
                        if (isArrEquals(arr, arr1)) {
                            list.add(strs[j]);
                            strs[j] = "-";
                        }
                    }
                }
            }
            strs[i] = "-";
            if (!list.isEmpty()) {
                res.add(list);
            }
        }
        return res;
    }

    int[] createAr(String s) {
        if (s == "-") return null;//new int[]{};
        int[] alphabet = new int[26];
        for (char x : s.toCharArray()) {
            alphabet[x - 'a']++;
        }
        return alphabet;
    }

    boolean isArrEquals(int[] ar1, int[] ar2) {
        if (ar1.length != ar2.length) {
            return false;
        }
        for (int i = 0; i < ar1.length; i++) {
            if (ar1[i] != ar2[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new GroupAnagrams().groupAnagrams(new String[]{"","b",""}));
    }
}
