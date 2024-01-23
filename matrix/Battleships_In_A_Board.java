package com.matrix;

public class Battleships_In_A_Board {

	public static void main(String[] args) {

		char[][] board = new char[][] { { 'X', '.', '.', 'X' }, { '.', '.', '.', 'X' }, { '.', '.', '.', 'X' } };
		int result_Approach1 = countBattleships_Approach1(board);
		System.out.println(result_Approach1);

//		int result_Approach2 = countBattleships_Approach2(board);
//		System.out.println(result_Approach2);

	}

	public static int countBattleships_Approach1(char[][] board) {
		if (board == null || board.length == 0)
			return 0;
		int result = 0;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] == 'X') {
					dfs(i, j, board);
					result++;
				}
			}
		}
		return result;
	}

	private static void dfs(int row, int col, char[][] board) {
		if (row < 0 || row >= board.length || col < 0 || col >= board[row].length || board[row][col] != 'X') {
			return;
		}
		board[row][col] = '.';
		dfs(row + 1, col, board);
		dfs(row, col + 1, board);
		dfs(row - 1, col, board);
		dfs(row, col + 1, board);
	}

	public static int countBattleships_Approach2(char[][] board) {
		if (board == null || board.length == 0)
			return 0;
		int result = 0;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] == '.') {
					continue;
				}
				if (i > 0 && board[i - 1][j] == 'X') {
					continue;
				}
				if (j > 0 && board[i][j - 1] == 'X') {
					continue;
				}
				result++;
			}
		}
		return result;
	}

}
