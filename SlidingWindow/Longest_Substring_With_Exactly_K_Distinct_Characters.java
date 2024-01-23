package com.sliding.window;

import java.util.HashMap;
import java.util.Map;

public class Longest_Substring_With_Exactly_K_Distinct_Characters {

	public static void main(String[] args) {

		String s = "aabacbebebe";
		int result = longestSubstring(s, 3);
		System.out.println(result);

	}

	public static int longestSubstring(String s, int k) {
		int i = -1;
		int j = -1;
		int result = 0;
		Map<Character, Integer> map = new HashMap<>();
		while (true) {
			boolean b1 = false;
			boolean b2 = false;
			while (j < s.length() - 1) {
				b1 = true;
				j++;
				char c = s.charAt(j);
				map.put(c, map.getOrDefault(c, 0) + 1);
				if (map.size() == k) {
					result = Math.max(result, j - i);
				} else if (map.size() < k) {
					continue;
				} else {
					break;
				}
			}
			while (i < j) {
				b2 = true;
				i++;
				char c = s.charAt(i);
				if (map.get(c) == 1) {
					map.remove(c);
				} else {
					map.put(c, map.get(c) - 1);
				}
				if (map.size() > k) {
					continue;
				} else {
					result = Math.max(result, i - j);
					break;
				}
			}
			if (!b1 && !b2) {
				break;
			}
		}
		return result;
	}

}
