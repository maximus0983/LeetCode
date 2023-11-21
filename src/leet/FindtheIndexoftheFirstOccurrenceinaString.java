package leet;

public class FindtheIndexoftheFirstOccurrenceinaString {
    public int strStr(String haystack, String needle) {
        int i = 0;
        if (!haystack.contains(needle)) {
            return -1;
        } else {
            i = haystack.indexOf(needle);
        }
        return i;
    }
}
