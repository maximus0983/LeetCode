package leet.seanPrashadList;

import java.util.HashSet;
import java.util.Set;

public class WordSearch {
    private Set<String> rezerved = new HashSet<>();

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (searchMatch(board, i, j, word, 0, new StringBuilder())) {
                        return true;
                    }
                } else {
                    if (!word.contains(String.valueOf(board[i][j]))) {
                        board[i][j] = 0;
                    }
                    rezerved.clear();
                }
            }
        }
        return false;
    }

    private boolean searchMatch(char[][] board, int col, int row, String word, int index, StringBuilder res) {
        if ((index == word.length() - 1) && nextPosition(board, col, row, word.charAt(index))) {
            res.append(word.charAt(index));
            return true;
        }
        if (!nextPosition(board, col, row, word.charAt(index))) {
            return false;
        }
        String position = col + "" + row;
        res.append(board[col][row]);
        rezerved.add(position);
        if (!rezerved.contains(col + 1 + "" + row) && searchMatch(board, col + 1, row, word, index + 1, res)) {
            return true;
        }
        if (!rezerved.contains(col + "" + (row + 1)) && searchMatch(board, col, row + 1, word, (index + 1), res)) {
            return true;
        }
        if (!rezerved.contains(col - 1 + "" + row) && searchMatch(board, col - 1, row, word, (index + 1), res)) {
            return true;
        }
        if (!rezerved.contains(col + "" + (row - 1)) && searchMatch(board, col, row - 1, word, (index + 1), res)) {
            return true;
        }
        rezerved.remove(position);
        res.deleteCharAt(res.length() - 1);
        return false;
    }

    private boolean nextPosition(char[][] board, int col, int row, char charAt) {
        return col >= 0 && col < board.length && row >= 0 && row < board[0].length && board[col][row] != 0 && board[col][row] == charAt;
    }

    public static void main(String[] args) {
        System.out.println(
//                new WordSearch().exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}
                new WordSearch().exist(new char[][]{{'C', 'A', 'A'},
                                {'A', 'A', 'A'},
                                {'B', 'C', 'D'}}
//                new WordSearch().exist(new char[][]{{'A', 'B'}}
                        , "AAB"));
    }
}
