package leet.seanPrashadList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsofaPhoneNumber {
    Map<Integer, char[]> mapp = new HashMap<>();

    {
        mapp.put(2, new char[]{'a', 'b', 'c'});
        mapp.put(3, new char[]{'d', 'e', 'f'});
        mapp.put(4, new char[]{'g', 'h', 'i'});
        mapp.put(5, new char[]{'j', 'k', 'l'});
        mapp.put(6, new char[]{'m', 'n', 'o'});
        mapp.put(7, new char[]{'p', 'q', 'r', 's'});
        mapp.put(8, new char[]{'t', 'u', 'v'});
        mapp.put(9, new char[]{'w', 'x', 'y', 'z'});
    }

    List<String> res = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        return findComb(digits, 0, new StringBuilder());
    }

    private List<String> findComb(String digits, int i, StringBuilder sb) {
        if (digits.length() == sb.length() && i >= digits.length() - 1) {
            res.add(sb.toString());
            return res;
        }
        char[] chars = mapp.get(Character.getNumericValue(digits.charAt(i)));
        for (int k = 0; k < chars.length; k++) {
            sb.append(chars[k]);
            findComb(digits, i + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new LetterCombinationsofaPhoneNumber().letterCombinations(
                "23"
        ));
    }
}
