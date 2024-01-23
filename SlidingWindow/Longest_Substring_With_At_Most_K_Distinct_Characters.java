package com.sliding.window;

import java.util.HashMap;
import java.util.Map;

public class Longest_Substring_With_At_Most_K_Distinct_Characters {

	public static void main(String[] args) {

		String s = "ddacbbaccdedacebb";
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
			while (i < s.length() - 1) {
				b1 = true;
				i++;
				char c = s.charAt(i);
				map.put(c, map.getOrDefault(c, 0) + 1);
				if (map.size() <= k) {
					result = Math.max(result, i - j);
				} else {
					break;
				}
			}
			while (j < i) {
				b2 = true;
				j++;
				char c = s.charAt(j);
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
