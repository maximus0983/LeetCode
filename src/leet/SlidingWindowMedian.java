package leet;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class SlidingWindowMedian {
    public double[] medianSlidingWindow(int[] nums, int k) {
        // System.out.println(nums.length);
        PriorityQueue<Integer> pl = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> pr = new PriorityQueue<>();
        List<Double> res = new ArrayList<>();
        int l = 0;
        int r = 0;
        int c = 0;
        int i = 0;
        while (i < k -1) {
            pl.add(nums[i]);
            i++;
        }
        i = 0;
        while (i < k / 2) {
            pr.add(pl.poll());
            i++;
        }
        c = pl.size() + pr.size();
        r = c;
        while (r < nums.length) {
//            if (pl.isEmpty()) {
//                if(pr.isEmpty() || pr.peek()!=null && nums[r] < pr.peek()){
//                    pl.add(nums[r]);
//                }else{
//                    pl.add(pr.poll());
//                    pr.add(nums[r]);
//                }
//
//            }else
//            {
//
//                if(pl.size() == pr.size()){
//                    if(nums[r] < pl.peek()){
//                        pl.add(nums[r]);
//                    }else{
//                        pr.add(nums[r]);
//                    }
//                }else if(pl.size() > pr.size()){
//                    if (nums[r] < pl.peek()) {
//                        pr.add(pl.poll());
//                        pl.add(nums[r]);
//                    }else{
//                        pr.add(nums[r]);
//                    }
//                }else{
//                    if (nums[r] > pr.peek()) {
//                        pl.add(pr.poll());
//                        pr.add(nums[r]);
//                    }else{
//                        pl.add(nums[r]);
//                    }
//                }
//            }
            Integer xl = pl.peek();
            Integer xr = pr.peek();
            if (xl == null) {
                if (xr == null || nums[r] <= xr) {
                    pl.add(nums[r]);
                } else if (nums[r] >= xr) {
                    pl.add(pr.poll());
                    pr.add(nums[r]);
                }
            } else if (xr == null) {
                if (nums[r] >= xl) {
                    pr.add(nums[r]);
                }else
                if (nums[r] <= xl) {
                    pr.add(pl.poll());
                    pl.add(nums[r]);
                }
            } else {
                if(pl.size() == pr.size()){
                    if(nums[r] <= pl.peek()){
                        pl.add(nums[r]);
                    }else{
                        pr.add(nums[r]);
                    }
                }else if(pl.size() >= pr.size()){
                    if (nums[r] < pl.peek()) {
                        pr.add(pl.poll());
                        pl.add(nums[r]);
                    }else{
                        pr.add(nums[r]);
                    }
                }else{
                    if (nums[r] >= pr.peek()) {
                        pl.add(pr.poll());
                        pr.add(nums[r]);
                    }else{
                        pl.add(nums[r]);
                    }
                }
            }

            c++;
            if (c == k) {
                System.out.print(pl + "-");
                System.out.println(pr);
                if (k % 2 == 0) {
                    long lon = (long)pl.peek()+ pr.peek();
                    res.add(lon/2.0);
                } else {
                    if (pl.size() > pr.size()) {
                        res.add(pl.peek() * 1.0);
                    } else
                        res.add(pr.peek() * 1.0);
                }
                if (pl.contains(nums[l])) {
                    pl.remove(nums[l]);
                } else {
                    pr.remove(nums[l]);
                }
                if(pl.size()>pr.size()&& pl.size() - pr.size()>1){
                    pr.add(pl.poll());
                }else if(pr.size()>pl.size() && pr.size() - pl.size()>1){
                    pl.add(pr.poll());
                }
                l++;
                c--;
            }
            r++;
        }
        double[] result = new double[res.size()];
        for (int j = 0; j < res.size(); j++) {
            result[j] = res.get(j);
        }
        return result;   }

    public static void main(String[] args) {
        double[] doubles = new SlidingWindowMedian().medianSlidingWindow(
                new int[]{-2147483648,-2147483648,2147483647,-2147483648,1,3,-2147483648,-100,8,17,22,-2147483648,-2147483648,2147483647,2147483647,2147483647,2147483647,-2147483648,2147483647,-2147483648}, 6
        );
        for (int i = 0; i < doubles.length; i++) {
            System.out.println(doubles[i]);
        }
//        long l = 2147483647;
//        System.out.println((l + 22)/2.0);
    }
}
