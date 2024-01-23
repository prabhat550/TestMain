package com.dp;

public class Maximal_Square {

    public static void main(String[] args) {

        char[][] array = new char[][] { { '1', '0', '1', '0', '0' }, { '1', '0', '1', '1', '1' },
                { '1', '1', '1', '1', '1' }, { '1', '0', '0', '1', '0' } };

        int result_maximalSquare = maximalSquare(array);
        System.out.println(result_maximalSquare);

    }

    public static int maximalSquare(char[][] matrix) {

        int rows = matrix.length;
        int columns = matrix[0].length;

        int[][] dp = new int[rows][columns];
        int result = 0;
        // First Row Traversal
        for (int i = 0; i < columns; i++) {
            dp[0][i] = matrix[0][i] == '0' ? 0 : 1;
            result = Math.max(result, dp[0][i]);
        }

        // First Column Traversal
        for (int i = 0; i < rows; i++) {
            dp[i][0] = matrix[i][0] == '0' ? 0 : 1;
            result = Math.max(result, dp[i][0]);
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < columns; j++) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                    result = Math.max(dp[i][j], result);
                }
            }
        }
        return result * result;
    }

}
