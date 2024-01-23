package com.backtracking.recursion;

import java.util.ArrayList;
import java.util.List;

public class Palindrome_Partitioning_I {

	public static void main(String[] args) {

		String s = "aab";
		List<List<String>> result = partition(s);
		System.out.println(result);

	}

	public static List<List<String>> partition(String s) {
		List<List<String>> result = new ArrayList<>();
		List<String> paths = new ArrayList<String>();
		dfs(s, 0, paths, result);
		return result;
	}

	private static void dfs(String s, int index, List<String> paths, List<List<String>> result) {
		if (index == s.length()) {
			result.add(new ArrayList<String>(paths));
			return;
		}
		for (int i = index; i < s.length(); i++) {
			if (isPalindrome(s, index, i)) {
				paths.add(s.substring(index, i + 1));
				dfs(s, i + 1, paths, result);
				paths.remove(paths.size() - 1);
			}
		}
	}

	private static boolean isPalindrome(String s, int start, int end) {
		while (start <= end) {
			if (s.charAt(start++) != s.charAt(end--)) {
				return false;
			}
		}
		return true;
	}

}
