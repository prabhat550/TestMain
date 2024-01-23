package com.dp;

import java.util.HashMap;

public class Longest_Arithmetic_Subsequence {

	public static void main(String[] args) {

		int[] array = new int[] { 9, 4, 7, 2, 10 };
		int result = longestArithSeqLength(array);
		System.out.println(result);

	}

	public static int longestArithSeqLength(int[] nums) {

		int length = nums.length;
		HashMap<Integer, Integer>[] dp = new HashMap[length];
		int maxValue = 1;

		for (int i = 0; i < length; i++) {
			
			int currentElement = nums[i];
			dp[i] = new HashMap<Integer, Integer>();
			HashMap<Integer, Integer> currentMap = dp[i];
			
			for (int j = 0; j < i; j++) {
				
				int difference = currentElement - nums[j];
				HashMap<Integer, Integer> prevMap = dp[j];
				currentMap.put(difference, prevMap.getOrDefault(difference, 0) + 1);
				dp[i] = currentMap;
				maxValue = Math.max(maxValue, currentMap.get(difference));
				
			}
		}
		return maxValue + 1;
	}

}


