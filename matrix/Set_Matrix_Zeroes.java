package com.matrix;

import java.util.Arrays;

public class Set_Matrix_Zeroes {

	public static void main(String[] args) {

		int[][] matrix = new int[][] { { 0, 1, 2, 0 }, { 3, 4, 5, 2 }, { 1, 3, 1, 5 } };
		setZeroes(matrix);
		printMatrix(matrix);
		printMatrix2D(matrix);

	}

	public static void setZeroes(int[][] matrix) {

		int R = matrix.length;
		int C = matrix[0].length;

		boolean rowFactor = false;
		boolean colFactor = false;

		for (int i = 0; i < R; i++) {
			if (matrix[i][0] == 0) {
				colFactor = true;
			}
		}

		for (int j = 0; j < C; j++) {
			if (matrix[0][j] == 0) {
				rowFactor = true;
			}
		}

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (matrix[i][j] == 0) {
					matrix[0][j] = 0;
					matrix[i][0] = 0;
				}
			}
		}

		for (int i = 1; i < R; i++) {
			if (matrix[i][0] == 0) {
				for (int j = 0; j < C; j++) {
					matrix[i][j] = 0;
				}
			}
		}

		for (int j = 1; j < C; j++) {
			if (matrix[0][j] == 0) {
				for (int i = 0; i < R; i++) {
					matrix[i][j] = 0;
				}
			}
		}

		if (rowFactor) {
			for (int j = 0; j < C; j++) {
				matrix[0][j] = 0;
			}
		}

		if (colFactor) {
			for (int i = 0; i < R; i++) {
				matrix[i][0] = 0;
			}
		}

	}

	public static void printMatrix(int[][] matrix) {

		int R = matrix.length;
		int C = matrix[0].length;

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(matrix[i][j] + " ");
			}
		}
		System.out.println();
	}

	public static void printMatrix2D(int[][] matrix) {

		for (int[] row : matrix) {
			System.out.println(Arrays.toString(row));
		}
	}

}
