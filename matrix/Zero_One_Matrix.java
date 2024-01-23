package com.matrix;

import java.util.LinkedList;
import java.util.Queue;

public class Zero_One_Matrix {

	public static void main(String[] args) {

		int[][] mat = new int[][] { { 0, 0, 0 }, { 0, 1, 0 }, { 1, 1, 1 } };
		int[][] result = updateMatrix(mat);
		System.out.println(result);

	}

	public static int[][] updateMatrix(int[][] mat) {
		Queue<int[]> queue = new LinkedList<>();
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++) {
				if (mat[i][j] == 0) {
					queue.add(new int[] { i, j });
				} else {
					mat[i][j] = -1;
				}
			}
		}
		int[][] dirs = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
		int len = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			len++;
			for (int i = 0; i < size; i++) {
				int[] cell = queue.poll();
				for (int[] dir : dirs) {
					int r = cell[0] + dir[0];
					int c = cell[1] + dir[1];
					if (r < 0 || r >= mat.length || c < 0 || c >= mat[r].length || mat[r][c] != -1) {
						continue;
					}
					mat[r][c] = len;
					queue.add(new int[] { r, c });
				}
			}
		}
		return mat;
	}

}
