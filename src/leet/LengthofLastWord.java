package leet;

public class LengthofLastWord {
    public int lengthOfLastWord(String s) {
        s.trim();
        String[] s1 = s.split(" ");
        return s1[s1.length - 1].length();
    }

    public static void main(String[] args) {
        int i = new LengthofLastWord().lengthOfLastWord("   fly me   to   the moon  ");
        System.out.println(i);
    }
}
