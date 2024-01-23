package com.matrix;

public class Word_Search_I {

	public static void main(String[] args) {

		char[][] board = new char[][] { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
		boolean result_exist = exist(board, "ABCCED");
		System.out.println(result_exist);

	}

	private static boolean[][] visited;

	public static boolean exist(char[][] board, String word) {
		if (board.length == 0)
			return false;
		int r = board.length;
		int c = board[0].length;
		visited = new boolean[r][c];
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (board[i][j] == word.charAt(0) && wordSearch(board, word, r, c, 0)) {
					return true;
				}
			}
		}
		return false;
	}

	private static boolean wordSearch(char[][] board, String word, int r, int c, int index) {

		if (index == word.length())
			return true;

		if (r < 0 || r >= board.length || c < 0 || c >= board[0].length || visited[r][c]
				|| word.charAt(index) != board[r][c]) {
			return false;
		}
		visited[r][c] = true;
		if (wordSearch(board, word, r + 1, c, index) || wordSearch(board, word, r, c + 1, index)
				|| wordSearch(board, word, r - 1, c, index) || wordSearch(board, word, r, c - 1, index)) {
			return true;
		}
		visited[r][c] = false;
		return false;

	}

}
