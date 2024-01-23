package com.matrix;

public class Max_Area_Of_Island {

	public static void main(String[] args) {

		int[][] grid = new int[][] { { 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 }, { 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0 }, { 0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0 } };
		int result = maxAreaOfIsland(grid);
		System.out.println(result);

	}

	public static int maxAreaOfIsland(int[][] grid) {
		int result = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == 1) {
					result = Math.max(result, dfs(i, j, grid));
				}
			}
		}
		return result;
	}

	private static int dfs(int row, int col, int[][] grid) {
		if (row < 0 || row >= grid.length || col < 0 || col >= grid[row].length || grid[row][col] == 0) {
			return 0;
		}
		int count = 1;
		grid[row][col] = 0;
		count += dfs(row + 1, col, grid);
		count += dfs(row, col + 1, grid);
		count += dfs(row - 1, col, grid);
		count += dfs(row, col - 1, grid);
		return count;
	}

}
