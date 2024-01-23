package com.sliding.window;

import java.util.HashMap;
import java.util.Map;

public class Minimum_Window_Substring {

	public static void main(String[] args) {
		String s = "ADOBECODEBANC";
		String t = "ABC";
		String result_OptimizedApproach = minWindow_OptimizedApproach(s, t);
		System.out.println(result_OptimizedApproach);
	}

	// Acquire And Release Approach
	public static String minWindow_OptimizedApproach(String s, String t) {
		Map<Character, Integer> tmap = new HashMap<>();
		Map<Character, Integer> transactionalMap = new HashMap<>();
		for (int i = 0; i < t.length(); i++) {
			tmap.put(t.charAt(i), tmap.getOrDefault(t.charAt(i), 0) + 1);
		}
		int requiredMatchCount = t.length();
		int transactionalMatchCount = 0;
		int i = 0;
		int j = 0;
		String result = "";
		while (true) {
			boolean flag1 = false;
			boolean flag2 = false;
			// Acquire
			while (i < s.length() && transactionalMatchCount < requiredMatchCount) {
				char ch = s.charAt(i);
				transactionalMap.put(ch, transactionalMap.getOrDefault(ch, 0) + 1);
				if (transactionalMap.getOrDefault(ch, 0) <= tmap.getOrDefault(ch, 0)) {
					transactionalMatchCount++;
				}
				i++;
			}
			// Release And Compute Result
			while (j < i && transactionalMatchCount == requiredMatchCount) {
				String tresult = s.substring(j, i);
				if (result.length() == 0 || tresult.length() < result.length()) {
					result = tresult;
				}
				char ch = s.charAt(j);
				if (transactionalMap.get(ch) == 1) {
					transactionalMap.remove(ch);
				} else {
					transactionalMap.put(ch, transactionalMap.get(ch) - 1);
				}
				if (transactionalMap.getOrDefault(ch, 0) < tmap.getOrDefault(ch, 0)) {
					transactionalMatchCount--;
				}
				j++;
				flag2 = true;
			}
			if (!flag1 && !flag2) {
				break;
			}
		}
		return result;
	}

}
