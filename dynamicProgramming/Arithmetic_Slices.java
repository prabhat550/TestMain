package com.dp;

public class Arithmetic_Slices {

	public static void main(String[] args) {

		int[] array = new int[] { 1, 2, 3, 4 };
		int result_numberOfArithmeticSlices = numberOfArithmeticSlices(array);
		System.out.println(result_numberOfArithmeticSlices);

	}

	public static int numberOfArithmeticSlices(int[] nums) {

		if (nums.length < 3 || nums == null)
			return 0;
		int[] dp = new int[nums.length];
		int result = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
				dp[i] += dp[i - 1] + 1;
				result += dp[i];
			}
		}
		return result;
	}
	
}
