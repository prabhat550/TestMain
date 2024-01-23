package com.dp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Word_Break {

	public static void main(String[] args) {

		List<String> wordDict = new ArrayList<>();
		Collections.addAll(wordDict, "pep", "coding", "pepcoding", "loves", "man", "go", "mango", "ice", "cream",
				"icecream");
		String s = "pepcodinglovesmangoicecream";
		boolean result_wordBreak = wordBreak(s, wordDict);
		System.out.println(result_wordBreak);

	}

	public static boolean wordBreak(String s, List<String> wordDict) {

		if (s == null)
			return false;

		int[] dp = new int[s.length()];
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j <= i; j++) {
				String word = s.substring(j, i + 1);
				if(wordDict.contains(word)) {
					if(j > 0) {
						dp[i] += dp[j - 1];
					}else {
						dp[i] += 1;
					}
				}
			}
		}
		System.out.println(dp[s.length() - 1]);
		return dp[s.length() - 1] > 0;
	}

}
