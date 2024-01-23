package com.matrix;

public class Number_Of_Enclaves {

	public static void main(String[] args) {

		int[][] grid = new int[][] { { 0, 0, 0, 0 }, { 1, 0, 1, 0 }, { 0, 1, 1, 0 }, { 0, 0, 0, 0 } };
		int result = numEnclaves(grid);
		System.out.println(result);

	}

	public static int numEnclaves(int[][] grid) {
		
		// Land at the boundary and connected to the boundary mark it as 0
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (i == 0 || j == 0 || i == grid.length - 1 || j == grid[i].length - 1) {
					if (grid[i][j] == 1) {
						dfs(i, j, grid);
					}
				}
			}
		}
		
		// Now identify the land in the matrix as this land will not be connected to the boundary
		int result = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == 1) {
					result++;
				}
			}
		}
		return result;
	}

	private static void dfs(int i, int j, int[][] grid) {
		if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == 0) {
			return;
		}
		grid[i][j] = 0;
		dfs(i + 1, j, grid);
		dfs(i, j + 1, grid);
		dfs(i - 1, j, grid);
		dfs(i, j - 1, grid);
	}

}
