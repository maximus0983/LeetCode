package leet.seanPrashadList;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    List<String> list = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        StringBuilder sb = new StringBuilder();
        sb.append('(');
        return searchAllCombo(n, sb, false, 1, 0);
    }

    private List<String> searchAllCombo(int n, StringBuilder stack, boolean isClose, int openBraceCount, int closedBraceCount) {
        if (openBraceCount == n) {
            createAndAddToResult(stack, openBraceCount - closedBraceCount);
            return list;
        }

        if (openBraceCount <= n) {
            stack.append('(');
            searchAllCombo(n, new StringBuilder(stack), openBraceCount + 1 - closedBraceCount == 0, openBraceCount + 1, closedBraceCount);
            if (!isClose) {
                stack.deleteCharAt(stack.length() - 1);
                stack.append(')');
                searchAllCombo(n, new StringBuilder(stack), openBraceCount - (closedBraceCount + 1) == 0, openBraceCount, closedBraceCount + 1);
            }
        }
        return list;
    }

    private void createAndAddToResult(StringBuilder sb, int i) {
        sb.append(")".repeat(Math.max(0, i)));
        list.add(sb.toString());
    }

    public static void main(String[] args) {
        System.out.println(new GenerateParentheses().generateParenthesis(3));
    }
}
