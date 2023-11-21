package leet.seanPrashadList;

import java.util.*;

public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    map.putIfAbsent(i, new ArrayList<>());
                    map.get(i).add(j);
                }
            }
        }
        for (int i : map.keySet()) {
            zeroLine(i, matrix);
            List<Integer> list = map.get(i);
            zeroColumn(list, matrix);
        }
        System.out.println(Arrays.deepToString(matrix));
    }

    private void zeroColumn(List<Integer> list, int[][] matrix) {
        for (int i = 0; i < list.size(); i++) {
            Integer integer = list.get(i);
            for (int j = 0; j < matrix.length; j++) {
                matrix[j][integer] = 0;
            }
        }
    }

    private void zeroLine(int i, int[][] matrix) {
        for (int j = 0; j < matrix[0].length; j++) {
            matrix[i][j] = 0;
        }
    }

    public static void main(String[] args) {
        new SetMatrixZeroes().setZeroes(
                new int[][]{{1,1,1},{1,0,1},{1,1,1}}
        );
    }
}
