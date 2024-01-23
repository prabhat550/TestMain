package com.dp;

public class House_Robber_I {

	public static void main(String[] args) {
		int[] array = new int[] { 1, 2, 3, 1 };

		int result_rob = rob_Approach1(array);
		System.out.println(result_rob);
	}

	private static Integer[] dp;

	// Tabulation
	public static int rob_Approach1(int[] nums) {

		if (nums == null || nums.length == 0) {
			return 0;
		}
		if (nums.length == 1) {
			return nums[0];
		}
		if (nums.length == 2) {
			return Math.max(nums[0], nums[1]);
		}
		int[] dp = new int[nums.length];
		dp[0] = nums[0];
		dp[1] = Math.max(nums[0], nums[1]);
		for (int i = 2; i < nums.length; i++) {
			dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
		}
		return dp[nums.length - 1];
	}

	// Recursion
	public static int rob_Approach2(int[] nums) {
		return helperMethod_Approach2(nums, 0);
	}

	private static int helperMethod_Approach2(int[] nums, int currentIndex) {
		if (currentIndex >= nums.length) {
			return 0;
		}
		int stealCurrent = nums[currentIndex] + helperMethod_Approach2(nums, currentIndex + 2);
		int skipCurrent = helperMethod_Approach2(nums, currentIndex + 1);
		return Math.max(stealCurrent, skipCurrent);
	}

	// Recursion + Memoization
	public static int rob_Approach3(int[] nums) {
		dp = new Integer[nums.length];
		return helperMethod_Approach3(nums, 0);
	}

	private static int helperMethod_Approach3(int[] nums, int currentIndex) {
		if (currentIndex >= nums.length) {
			return 0;
		}
		if (dp[currentIndex] != null) {
			return dp[currentIndex];
		}
		int stealCurrent = nums[currentIndex] + helperMethod_Approach2(nums, currentIndex + 2);
		int skipCurrent = helperMethod_Approach2(nums, currentIndex + 1);
		return dp[currentIndex] = Math.max(stealCurrent, skipCurrent);
	}

}
