package leet.seanPrashadList;

public class CountingBits {
    public int[] countBits(int n) {
        int[] arr = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            arr[i] = countOnes(i);
        }
        return arr;
    }

    private int countOnes(int i) {
        int count = 0;
        while (i > 0) {
            i = i & (i - 1);
            count++;
        }
        return count;
    }


    public static void main(String[] args) {
        new CountingBits().countBits(5);
    }
}
