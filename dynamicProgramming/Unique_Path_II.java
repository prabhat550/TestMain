package com.dp;

public class Unique_Path_II {

	public static void main(String[] args) {

		int[][] array = new int[][] { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } };

		int result_uniquePathsWithObstacles = uniquePathsWithObstacles(array);
		System.out.println(result_uniquePathsWithObstacles);

	}

	public static int uniquePathsWithObstacles(int[][] obstacleGrid) {

		if (obstacleGrid.length == 0 || obstacleGrid == null || obstacleGrid[0][0] == 1) {
			return 0;
		}

		int row = obstacleGrid.length;
		int column = obstacleGrid[0].length;
		int[][] dp = new int[row][column];
		// First Row
		for (int i = 0; i < column; i++) {
			if (obstacleGrid[0][i] == 0) {
				dp[0][i] = 1;
			} else {
				break;
			}
		}
		// First Column
		for (int i = 0; i < row; i++) {
			if (obstacleGrid[i][0] == 0) {
				dp[i][0] = 1;
			} else {
				break;
			}
		}
		for (int i = 1; i < row; i++) {
			for (int j = 1; j < column; j++) {
				if (obstacleGrid[i][j] == 1) {
					dp[i][j] = 0;
				} else {
					dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
				}
			}
		}
		return dp[row - 1][column - 1];
	}

}
