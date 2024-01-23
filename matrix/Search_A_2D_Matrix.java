package com.matrix;

public class Search_A_2D_Matrix {

    public static void main(String[] args) {

        int[][] array = new int[][] { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 60 } };
        boolean result_searchMatrix = searchMatrix(array, 3);
        System.out.println(result_searchMatrix);

    }

    public static boolean searchMatrix(int[][] matrix, int target) {

        if (matrix.length == 0 || matrix == null)
            return false;

        int row = matrix.length;
        int col = matrix[0].length;

        int left = 0;
        int right = row * col - 1;

        while (left <= right) {
            int midpoint = left + (right - left) / 2;
            int mid_element = matrix[midpoint / col][midpoint % col];

            if (mid_element == target) {
                return true;
            } else if (target < mid_element) {
                right = midpoint - 1;
            } else {
                left = midpoint + 1;
            }
        }
        return false;
    }
}
