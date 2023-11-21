package leet;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        Map<String, Set<Character>> map = new HashMap<>();
        map.put("i0", new HashSet<>());
        map.put("i1", new HashSet<>());
        map.put("i2", new HashSet<>());
        map.put("i3", new HashSet<>());
        map.put("i4", new HashSet<>());
        map.put("i5", new HashSet<>());
        map.put("i6", new HashSet<>());
        map.put("i7", new HashSet<>());
        map.put("i8", new HashSet<>());
        map.put("j0", new HashSet<>());
        map.put("j1", new HashSet<>());
        map.put("j2", new HashSet<>());
        map.put("j3", new HashSet<>());
        map.put("j4", new HashSet<>());
        map.put("j5", new HashSet<>());
        map.put("j6", new HashSet<>());
        map.put("j7", new HashSet<>());
        map.put("j8", new HashSet<>());
        map.put("33", new HashSet<>());
        map.put("36", new HashSet<>());
        map.put("39", new HashSet<>());
        map.put("63", new HashSet<>());
        map.put("66", new HashSet<>());
        map.put("69", new HashSet<>());
        map.put("93", new HashSet<>());
        map.put("96", new HashSet<>());
        map.put("99", new HashSet<>());
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                char c = board[i][j];
                Set<Character> rows = map.get("i" + i);
                Set<Character> columns = map.get("j" + j);
                Set<Character> square = map.get(computeSquareKey(i, j));
                if (c != '.') {
                    if (rows.contains(c) || columns.contains(c) || square.contains(c)) {
                        System.out.println("rows "+rows.contains(c));
                        System.out.println("column "+columns.contains(c));
                        System.out.println("square "+square.contains(c));
                        System.out.println("i" + i + " " + "j" + j);
                        return false;
                    }
                    rows.add(c);
                    columns.add(c);
                    square.add(c);
                }
            }
        }
        return true;
    }

    private String computeSquareKey(int i, int j) {
        String key;
        if (i < 3) {
            if (j < 3) {
                key = "33";
            } else if (j < 6) {
                key = "36";
            } else {
                key = "39";
            }
        } else if (i < 6) {
            if (j < 3) {
                key = "63";
            } else if (j < 6) {
                key = "66";
            } else {
                key = "69";
            }
        } else {
            if (j < 3) {
                key = "93";
            } else if (j < 6) {
                key = "96";
            } else {
                key = "99";
            }
        }
        return key;
    }

    public static void main(String[] args) {
//        System.out.println(new ValidSudoku().isValidSudoku(
//                new char[][]{
//                        {'8', '3', '.', '.', '7', '.', '.', '.', '.'}
//                        , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
//                        , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
//                        , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
//                        , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
//                        , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
//                        , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
//                        , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
//                        , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
//                }
//        ));
        System.out.println(new ValidSudoku().isValidSudoku(
                new char[][]{
                        {'5', '3', '.', '.', '7', '.', '.', '.', '.'}
                        , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                        , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                        , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                        , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                        , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                        , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                        , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                        , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
                }
        ));
//        new ValidSudoku().computeSquareKey(7, 8);
    }
}
