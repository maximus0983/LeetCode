package leet;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int max = 0;
        int[] h = height;
        int l = 0;
        int n = height.length - 1;
        int r = n;
        while(l<r){
            max = Math.max(max, Math.min(h[l], h[r]) * (r-l));
            if(h[l]<h[r]){
                l++;
            }else r--;
        }

        return max;
    }

//    public static void main(String[] args) {
//        System.out.println(new ContainerWithMostWater().maxArea(
//                new int[]{1,8,6,2,5,4,8,3,7}
//        ));
        public static void main(String[] args) throws Exception {
            BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
            Set<Integer> set = new HashSet<>();
            set.add(1);
            set.add(2);
            StringBuilder s= new StringBuilder();
            s.append("2");
            int len = Integer.valueOf(r.readLine());
            int[] n = new int[len];

            for (int i = 0; i < len; ++i){
                n[i] = Integer.valueOf(r.readLine());
            }

            List<ListNode> f = new ArrayList<>();
            f.sort((a,b)-> Integer.compare(a.val,b.val));
            System.out.println(set);
    }
}
