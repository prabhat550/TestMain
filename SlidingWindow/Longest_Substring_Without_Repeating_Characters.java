package com.sliding.window;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Longest_Substring_Without_Repeating_Characters {

	public static void main(String[] args) {

		String s = "abcabcbb";
		int result_Approach1 = lengthOfLongestSubstring_Approach1(s);
		System.out.println(result_Approach1);

		int result_Approach2 = lengthOfLongestSubstring_Approach2(s);
		System.out.println(result_Approach2);

	}

	public static int lengthOfLongestSubstring_Approach1(String s) {
		int left = 0;
		int right = 0;
		int n = s.length();
		int result = 0;
		Map<Character, Integer> map = new HashMap<>();
		while (right < n) {
			if (map.containsKey(s.charAt(right))) {
				left = Math.max(map.get(s.charAt(right)) + 1, left);
			}
			map.put(s.charAt(right), right);
			result = Math.max(result, right - left + 1);
			right++;
		}
		return result;
	}

	public static int lengthOfLongestSubstring_Approach2(String s) {
		int left = 0;
		int right = 0;
		int result = 0;
		Set<Character> set = new HashSet<>();
		for (int i = 0; i < s.length(); i++) {
			if (set.contains(s.charAt(i))) {
				set.remove(s.charAt(left));
				left++;
			} else {
				set.add(s.charAt(i));
				result = Math.max(result, right - left + 1);
				right++;
			}
		}
		return result;
	}

}
