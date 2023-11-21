package leet;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PlusOne {
    public int[] plusOne(int[] digits) {
        String collect = Arrays.stream(digits).mapToObj(String::valueOf).collect(Collectors.joining());
        BigDecimal i = new BigDecimal(collect);
        BigDecimal add = i.add(BigDecimal.ONE);
        String s = String.valueOf(add);
        List<Integer> collect1 = Arrays.stream(s.split(""))
                .mapToInt(Integer::valueOf)
                .boxed()
                .collect(Collectors.toList());
        int[] res = new int[collect1.size()];
        for (int j = 0; j < collect1.size(); j++) {
            res[j] = collect1.get(j);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new PlusOne().plusOne(new int[]{9,8,7,6,5,4,3,2,1,0})));
    }
}
