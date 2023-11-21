package leet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAllAnagramsinaString {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        for(char c: p.toCharArray()){
            map.put(c, map.getOrDefault(c,0) +1);
        }
        int l = 0;
        int r = 0;
        int count = map.size();

        while(r<s.length()){
            char c = s.charAt(r);
            if(map.containsKey(c)){
                map.put(c, map.get(c) -1);
                if(map.get(c) == 0){
                    count--;
                }
            }
            while (count == 0){
                if(map.containsKey(s.charAt(l))){
                    map.put(s.charAt(l), map.get(s.charAt(l)) +1);
                    if(map.get(s.charAt(l)) >0){
                        count++;}
                }
                if (r - l == p.length() - 1) {
                    res.add(l);
                }
                l++;
            }
            r++;
        }
        return res;
    }

    public static void main(String[] args) {
        String s ="aabaa";
        String p ="aa";
        System.out.println(new FindAllAnagramsinaString().findAnagrams(s,p
        ));
    }
}
