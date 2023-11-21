package leet;

public class LongetCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 1 || strs[0].equals("")) {
            return strs[0];
        }
        boolean commonChar = true;
        int j = 0;
        while (commonChar && j < strs[0].length()) {
            char c;
            c = strs[0].charAt(j);
            for (int i = 1; i < strs.length; i++) {
                if (strs[i].equals("")) {
                    return "";
                }
                if (j >= strs[i].length()) {
                    commonChar = false;
                } else if (strs[i].charAt(j) != c) {
                    commonChar = false;
                    if (j == 0) {
                        return "";
                    }
                }
            }
            if (commonChar) {
                j++;
            }
        }
        return strs[0].substring(0, j);

    }

    public static void main(String[] args) {
        System.out.println(new LongetCommonPrefix().longestCommonPrefix(new String[]{"ab", "a"}));
        System.out.println(new LongetCommonPrefix().longestCommonPrefix(new String[]{"flower", "flower"}));
        System.out.println(new LongetCommonPrefix().longestCommonPrefix(new String[]{"flower","flow","flight"}));
        System.out.println(new LongetCommonPrefix().longestCommonPrefix(new String[]{"dog","racecar","car"}));
        System.out.println(new LongetCommonPrefix().longestCommonPrefix(new String[]{"cir","car"}));
    }
}
