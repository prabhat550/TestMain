package com.matrix;

public class Maximal_Square {

    public static void main(String[] args) {

        char[][] array = new char[][] { { '1', '0', '1', '0', '0' }, { '1', '0', '1', '1', '1' },
                { '1', '1', '1', '1', '1' }, { '1', '0', '0', '1', '0' } };
        int result_maximalSquare = maximalSquare(array);

        System.out.println(result_maximalSquare);
    }

    public static int maximalSquare(char[][] matrix) {

        if (matrix.length == 0 || matrix == null)
            return 0;

        int row = matrix.length;
        int column = matrix[0].length;

        int max = 0;
        int[][] dp = new int[row][column];

        // For the first row
        for (int i = 0; i < column; i++) {
            dp[0][i] = matrix[0][i] == '0' ? 0 : 1;
            max = Math.max(dp[0][i], max);
        }

        // For the first column
        for (int i = 0; i < row; i++) {
            dp[i][0] = matrix[i][0] == '0' ? 0 : 1;
            max = Math.max(dp[i][0], max);
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < column; j++) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                    max = Math.max(dp[i][j], max);
                }
            }
        }
        return max * max;
    }

}
