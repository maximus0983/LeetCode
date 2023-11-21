package leet;

import java.util.ArrayDeque;
import java.util.Deque;

public class Parentheses {
    public boolean isValid(String s) {
        String[] split = s.split("");
        Deque<String> queue = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            if ("(".equals(split[i]) || "{".equals(split[i]) || "[".equals(split[i])) {
                queue.push(split[i]);
            } else {
                if (queue.isEmpty()) {
                    return false;
                }
                String poll = queue.pop();
                if ("(".equals(poll) && !")".equals(split[i])
                        || "{".equals(poll) && !"}".equals(split[i])
                        || "[".equals(poll) && !"]".equals(split[i])) {
                    return false;
                }
            }
        }
        return queue.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(new Parentheses().isValid("("));
    }
}
