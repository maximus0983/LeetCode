package leet.seanPrashadList;

import java.util.Stack;

public class BackspaceStringCompare {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> stack = new Stack<>();
        Stack<Character> stack2 = new Stack<>();
        String s1 = "";
        String s2 = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '#'&&!stack.isEmpty()) {
                stack.pop();
            } else if (s.charAt(i) != '#'){
                stack.push(s.charAt(i));
            }
        }
        for (int i = 0; i < t.length(); i++) {
            if (t.charAt(i) == '#'&&!stack2.isEmpty()) {
                stack2.pop();
            } else if (t.charAt(i) != '#'){
                stack2.push(t.charAt(i));
            }
        }
        if (stack.size() != stack2.size()) {
            return false;
        } else {
            while (!stack.isEmpty()) {
                s1 = s1 + stack.pop();
            }
            while (!stack2.isEmpty()) {
                s2 = s2 + stack2.pop();
            }
        }
        return s2.equals(s1);
    }

    public static void main(String[] args) {
        System.out.println(new BackspaceStringCompare().backspaceCompare(
                "y#fo##f", "y#f#o##f"
//                "a#c", "b"
        ));
    }
}
