package com.backtracking.recursion;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Word_Search_II {

	public static void main(String[] args) {

		char[][] board = new char[][] { { 'o', 'a', 'a', 'n' }, { 'e', 't', 'a', 'e' }, { 'i', 'h', 'k', 'r' },
				{ 'i', 'f', 'l', 'v' } };
		String[] words = new String[] { "oath", "pea", "eat", "rain" };
		List<String> result = findWords(board, words);
		System.out.println(result);

	}

	private static TrieNode root = new TrieNode();
	private static boolean[][] visited;

	public static List<String> findWords(char[][] board, String[] words) {
		Set<String> result = new HashSet<>();
		addToTrie(words);
		int r = board.length;
		int c = board[0].length;
		visited = new boolean[r][c];
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (root.child[board[i][j] - 'a'] != null) {
					search(board, i, j, root, "", result);
				}
			}
		}
		return new LinkedList<String>(result);
	}

	private static void search(char[][] board, int r, int c, TrieNode node, String s, Set<String> result) {
		if (r < 0 || r >= board.length || c < 0 || c >= board[r].length || visited[r][c]
				|| node.child[board[r][c] - 'a'] == null)
			return;
		visited[r][c] = true;
		node = node.child[board[r][c] - 'a'];
		if (node.isWord) {
			result.add(s + board[r][c]);
		}
		search(board, r + 1, c, node, s + board[r][c], result);
		search(board, r, c + 1, node, s + board[r][c], result);
		search(board, r - 1, c, node, s + board[r][c], result);
		search(board, r, c - 1, node, s + board[r][c], result);

		visited[r][c] = false;

	}

	private static void addToTrie(String[] words) {
		for (String word : words) {
			TrieNode node = root;
			for (int i = 0; i < word.length(); i++) {
				char ch = word.charAt(i);
				if (node.child[ch - 'a'] == null) {
					node.child[ch - 'a'] = new TrieNode();
				}
				node = node.child[ch - 'a'];
			}
			node.isWord = true;
		}
	}

}

class TrieNode {

	public boolean isWord;
	public TrieNode[] child = new TrieNode[26];

	public TrieNode() {
	}
}
