package com.dp;

public class Minimum_Path_Sum {

    public static void main(String[] args) {

        int[][] array = new int[][] { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } };
        int result_minPathSum = minPathSum(array);
        System.out.println(result_minPathSum);
    }

    // https://leetcode.com/problems/minimum-path-sum/
    public static int minPathSum(int[][] grid) {

        if (grid.length == 0 || grid == null)
            return 0;

        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {

                dp[i][j] += grid[i][j];

                if (i > 0 && j > 0) {
                    dp[i][j] += Math.min(dp[i - 1][j], dp[i][j - 1]);
                }

                else if (i > 0) {
                    dp[i][j] += dp[i - 1][j];
                }

                else if (j > 0) {
                    dp[i][j] += dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }

}
