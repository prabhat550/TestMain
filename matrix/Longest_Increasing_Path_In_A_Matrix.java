package com.matrix;

public class Longest_Increasing_Path_In_A_Matrix {

	public static void main(String[] args) {

		int[][] matrix = new int[][] { { 9, 9, 4 }, { 6, 6, 8 }, { 2, 1, 1 } };
		int result = longestIncreasingPath(matrix);
		System.out.println(result);

	}

	public static int longestIncreasingPath(int[][] matrix) {

		int[][] directions = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
		int m = matrix.length;
		int n = matrix[0].length;
		int maxLength = 0;
		if (matrix == null || matrix.length == 0)
			return 0;

		int[][] dp = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				System.out.println(matrix[i][j]);
				maxLength = Math.max(maxLength, dfs(matrix, i, j, m, n, directions, dp));
			}
		}
		return maxLength;
	}

	private static int dfs(int[][] matrix, int i, int j, int m, int n, int[][] directions, int[][] dp) {
		if (i < 0 || i >= m || j < 0 || j >= n)
			return 0;
		if (dp[i][j] != 0)
			return dp[i][j];
		int curr = 1;
		for (int[] direction : directions) {
			int x = i + direction[0];
			int y = j + direction[1];
			if (x < 0 || x >= m || y < 0 || y >= n)
				continue;
			if (matrix[x][y] <= matrix[i][j])
				continue;
			curr = Math.max(curr, dfs(matrix, x, y, m, n, directions, dp) + 1);
		}
		dp[i][j] = curr;
		return curr;
	}

}
