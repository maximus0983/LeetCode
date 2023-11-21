package leet.seanPrashadList;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {
    List<String> res = new ArrayList<>();

    public List<String> letterCasePermutation(String s) {
        if (s.length() == 1 && Character.isLetter(s.charAt(0))) {
            res.add(s.toLowerCase());
            res.add(s.toUpperCase());
            return res;
        }
        collect(s, 0);
        return res;
    }

    private String collect(String s, int i) {
        if (i > s.length() - 1) {
            res.add(s);
            return s;
        }
        while (i < s.length() && Character.isDigit(s.charAt(i))) {
            i++;
        }
        if (i == s.length()) {
            res.add(s);
            return s;
        }
        collect(changeCaseAtIndex(s, i), i + 1);
        collect(s, i + 1);
        return s;
    }

    public static String changeCaseAtIndex(String str, int index) {
        if (str == null || index < 0 || index > str.length() - 1) {
            return str;
        }
        char ch = str.charAt(index);
        if (Character.isUpperCase(ch)) {
            ch = Character.toLowerCase(ch);
        } else {
            ch = Character.toUpperCase(ch);
        }
        StringBuilder sb = new StringBuilder(str);
        sb.setCharAt(index, ch);
        return sb.toString();
    }


    public static void main(String[] args) {
        System.out.println(new LetterCasePermutation().letterCasePermutation("a1b2"));
        System.out.println(new LetterCasePermutation().letterCasePermutation("12345"));
        System.out.println(new LetterCasePermutation().letterCasePermutation("c"));
        System.out.println(new LetterCasePermutation().letterCasePermutation("po"));
        System.out.println(new LetterCasePermutation().letterCasePermutation("O9"));
    }
}
