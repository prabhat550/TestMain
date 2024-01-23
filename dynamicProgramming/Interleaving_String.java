package com.dp;

public class Interleaving_String {

	public static void main(String[] args) {

		String s1 = "aabcc";
		String s2 = "dbbca";
		String s3 = "aadbbcbcac";

		boolean result_Approach1 = isInterleave_Approach1(s1, s2, s3);
		System.out.println(result_Approach1);

		boolean result_Approach2 = isInterleave_Approach2(s1, s2, s3);
		System.out.println(result_Approach2);

	}

	// Recursion Approach
	public static boolean isInterleave_Approach1(String s1, String s2, String s3) {

		return helperMethod_Approach1(s1, s2, s3, 0, 0);
	}

	private static boolean helperMethod_Approach1(String s1, String s2, String s3, int i, int j) {

		if (i == s1.length() && j == s2.length()) {
			return true;
		}
		if (i < s1.length() && s1.charAt(i) == s3.charAt(i + j)) {
			boolean f1 = helperMethod_Approach1(s1, s2, s3, i + 1, j);
			if (f1) {
				return true;
			}
		}
		if (j < s2.length() && s2.charAt(j) == s3.charAt(i + j)) {
			boolean f2 = helperMethod_Approach1(s1, s2, s3, i, j + 1);
			if (f2) {
				return true;
			}
		}

		return false;
	}

	// Recursion Approach With Memoization
	public static boolean isInterleave_Approach2(String s1, String s2, String s3) {

		return helperMethod_Approach2(s1, s2, s3, 0, 0, new Boolean[s1.length() + 1][s2.length() + 1]);
	}

	private static boolean helperMethod_Approach2(String s1, String s2, String s3, int i, int j, Boolean[][] visited) {

		if (i == s1.length() && j == s2.length()) {
			return true;
		}
		if (visited[i][j] != null) {
			return visited[i][j];
		}
		if (i < s1.length() && s1.charAt(i) == s3.charAt(i + j)) {
			boolean f1 = helperMethod_Approach2(s1, s2, s3, i + 1, j, visited);
			visited[i][j] = f1;
			if (f1) {
				return true;
			}
		}
		if (j < s2.length() && s2.charAt(j) == s3.charAt(i + j)) {
			boolean f2 = helperMethod_Approach2(s1, s2, s3, i, j + 1, visited);
			visited[i][j] = f2;
			if (f2) {
				return true;
			}
		}
		visited[i][j] = false;
		return false;
	}

}
