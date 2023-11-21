package leet;

import java.util.*;

public class RomanNumber {
    private Map<String, Integer> map = new HashMap<>();

    {
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);
    }

    public int romanToInt(String s) {
        Queue<String> queue = new ArrayDeque<>(List.of(s.split("")));
        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            String i = queue.poll();
            String next = queue.peek();
            if (i.equals("I") && ("V".equals(next) || "X".equals(next))
                    || i.equals("X") && ("L".equals(next) || "C".equals(next))
                    || i.equals("C") && ("D".equals(next) || "M".equals(next))) {
                Integer integer = map.get(i);
                Integer integer1 = map.get(queue.poll());
                list.add(integer1 - integer);
            } else {
                list.add(map.get(i));
            }
        }
        return list.stream().reduce(0,Integer::sum);
    }

    public static void main(String[] args) {
        System.out.println(new RomanNumber().romanToInt("MCMXCIV"));
    }
}
