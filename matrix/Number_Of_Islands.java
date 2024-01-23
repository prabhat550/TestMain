package com.matrix;

public class Number_Of_Islands {

    public static void main(String[] args) {
        char[][] grid = new char[][] { { '1', '1', '1', '1', '0' }, { '1', '1', '0', '1', '0' },
                { '1', '1', '0', '0', '0' }, { '0', '0', '0', '0', '0' } };
        int result_grid = numIslands(grid);
        System.out.println(result_grid);

    }

    public static int numIslands(char[][] grid) {

        int numberOfIslands = 0;
        int row = grid.length;
        int column = grid[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (grid[i][j] == '1') {
                    numberOfIslands++;
                    helperMethod(grid, i, j);
                }
            }
        }

        return numberOfIslands;
    }

    public static void helperMethod(char[][] grid, int i, int j) {

        if (i < 0 || i > grid.length - 1 || j < 0 || j > grid[0].length - 1 || grid[i][j] == '0')
            return;

        grid[i][j] = '0';

        helperMethod(grid, i + 1, j);
        helperMethod(grid, i - 1, j);
        helperMethod(grid, i, j + 1);
        helperMethod(grid, i, j - 1);

    }

}
