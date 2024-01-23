package com.dp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Word_Break_II {

	public static void main(String[] args) {

		List<String> wordDict = new ArrayList<>();
		Collections.addAll(wordDict, "pep", "coding", "pepcoding", "loves", "man", "go", "mango");
		String s = "pepcodinglovesmango";
		
		List<String> result_wordBreak = wordBreak(s, wordDict);
		System.out.println(result_wordBreak);

	}

	private static List<String> res = new ArrayList<>();

	public static List<String> wordBreak(String s, List<String> wordDict) {

		Set<String> set = new HashSet<>(wordDict);
		check(s, set, 0, 0, new StringBuilder());
		return res;

	}

	private static void check(String s, Set<String> set, int start, int init, StringBuilder sb) {

		for (int end = init + 1; end <= s.length(); end++) {
			String sub = s.substring(start, end);
			if (set.contains(sub)) {
				check(s, set, start, end, new StringBuilder(sb.toString()));
				sb.append(sub);
				if (end == s.length()) {
					res.add(sb.toString());
				} else {
					sb.append(" ");
				}
				start = end;
			}
		}
	}
}
