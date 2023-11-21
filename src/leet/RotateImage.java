package leet;

public class RotateImage {
    public void rotate(int[][] matrix) {
        for (int i = 0; i < matrix.length - 1; i++) {
            for (int j = i + 1; j < matrix[0].length; j++) {
                swapDaigonal(matrix, i, j);
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length / 2; j++) {
                if (matrix[i][j] != matrix[i][matrix[0].length-1 - j]) {
                    swapMirror(matrix, i, j,matrix[0].length-1 - j);
                }
            }
        }
    }

    private void swapDaigonal(int[][] matrix, int i, int j) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
    }

    private void swapMirror(int[][] matrix, int i, int j, int mirrJ) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[i][mirrJ];
        matrix[i][mirrJ] = temp;
    }

    public static void main(String[] args) {
        new RotateImage().rotate(
                new int[][]{{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}}
        );
    }
}
