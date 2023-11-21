package leet;

public class FirstBadVersion {
    public int firstBadVersion(int n) {
        long left = 1;
        long right = n;
        int mid = -1;
        while(left<=right){
            mid = (int) ((left + right) / 2);
            boolean res = isBadVersion(mid);
            if(res){
                right = mid -1;
            }else left = mid +1;
        }
        return isBadVersion(mid)? mid:mid+1;
    }

    private boolean isBadVersion(int mid) {
        return mid >= 1702766719;
    }

    public static void main(String[] args) {
        System.out.println(new FirstBadVersion().firstBadVersion(2126753390));
    }
}
