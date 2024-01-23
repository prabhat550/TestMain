package com.matrix;

public class Path_With_Maximum_Gold {

	public static void main(String[] args) {

		int[][] grid = new int[][] { { 0, 6, 0 }, { 5, 8, 7 }, { 0, 9, 0 } };
		int result = getMaximumGold(grid);
		System.out.println(result);

	}

	private static int max = 0;

	public static int getMaximumGold(int[][] grid) {
		int r = grid.length;
		int c = grid[0].length;
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (grid[i][j] != 0) {
					dfs(grid, i, j, 0);
				}
			}
		}
		return max;
	}

	private static void dfs(int[][] grid, int r, int c, int cur) {
		if (r < 0 || r >= grid.length || c < 0 || c >= grid[r].length || grid[r][c] == 0) {
			return;
		}
		int val = grid[r][c];
		max = Math.max(max, cur + val);
		grid[r][c] = 0;
		dfs(grid, r + 1, c, cur + val);
		dfs(grid, r - 1, c, cur + val);
		dfs(grid, r, c + 1, cur + val);
		dfs(grid, r, c - 1, cur + val);
		grid[r][c] = val;
	}

}
