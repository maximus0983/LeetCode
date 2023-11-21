package leet.seanPrashadList;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
//        if (matrix[0].length == 1) {
//            for (int i = 0; i < matrix.length; i++) {
//                list.add(matrix[i][0]);
//            }
//        } else {
//            for (int i = 0; i < (matrix.length / 2 + (matrix.length % 2 == 0 ? 0 : 1)); i++) {
//                for (int j = i; j < matrix[0].length - i; j++) {
//                    list.add(matrix[i][j]);
//                }
//                for (int j = i + 1; j < matrix.length - 1 - i; j++) {
//                    list.add(matrix[j][matrix[0].length - 1 - i]);
//                }
//                for (int j = matrix[0].length - 1 - i; j > i && (matrix.length - 1 - i) > i; j--) {
//                    list.add(matrix[matrix.length - 1 - i][j]);
//                }
//                for (int j = matrix.length - 1 - i; j > i; j--) {
//                    list.add(matrix[j][i]);
//                }
//            }
//        }
        int quantity = matrix.length * matrix[0].length;
        int count = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[0].length - i; j++) {
                if (count >= quantity) {
                    break;
                }
                count++;
                list.add(matrix[i][j]);
            }
            for (int j = i + 1; j < matrix.length - i; j++) {
                if (count >= quantity) {
                    break;
                }
                count++;
                list.add(matrix[j][matrix[0].length - 1 - i]);
            }
            for (int j = matrix[0].length - 2 - i; j > i; j--) {
                if (count >= quantity) {
                    break;
                }
                count++;
                list.add(matrix[matrix.length - 1 - i][j]);
            }
            for (int j = matrix.length - 1 - i; j > i; j--) {
                if (count >= quantity) {
                    break;
                }
                count++;
                list.add(matrix[j][i]);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(new SpiralMatrix().spiralOrder(
                new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}}
//                new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}
//        new int[][]{{1}, {4}}
//        new int[][]{{1,9,7}}
//                new int[][]{{1}, {2}, {3}}
//                new int[][]{{2, 5, 8}, {4, 0, -1}}
//                new int[][]{{2,  3,  4},
//                            {5,  6,  7},
//                            {8,  9,  10},
//                            {11, 12, 13},
//                            {14, 15, 16}}
        ));
    }
}
