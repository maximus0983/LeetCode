package leet.seanPrashadList;

public class FindSmallestLetterGreaterThanTarget {
    public char nextGreatestLetter(char[] letters, char target) {
        int left = 0;
        int right = letters.length - 1;
        int mid;
        while (left <= right) {
            mid = (left + right) / 2;
            if (mid!=0&&letters[mid - 1] <= target && target < letters[mid]) {
                return letters[mid];
            } else if (target >= letters[mid]) {
                left = mid + 1;
            } else right = mid - 1;
        }
        return letters[0];
    }

    public static void main(String[] args) {
        System.out.println(new FindSmallestLetterGreaterThanTarget().nextGreatestLetter(
                new char[]{'e','e','e','e','e','e','n','n','n','n','n'}, 'e'
        ));
    }
}
