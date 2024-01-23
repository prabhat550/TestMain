package com.dp;

public class Longest_Increasing_Subsequence {

	public static void main(String[] args) {

		int[] array = new int[] { 10, 9, 2, 5, 3, 7, 101, 18 };
		int result_lengthOfLIS = lengthOfLIS(array);
		System.out.println(result_lengthOfLIS);

	}

	public static int lengthOfLIS(int[] nums) {

		if (nums.length == 0 || nums == null)
			return 0;
		int result = 0;
		int[] dp = new int[nums.length];
		for (int i = 0; i < dp.length; i++) {
			int max = 0;
			for (int j = 0; j < i; j++) {
				if (nums[j] < nums[i]) {
					max = Math.max(max, dp[j]);
				}
			}
			dp[i] = max + 1;
			result = Math.max(result, dp[i]);
		}
		return result;
	}

}
