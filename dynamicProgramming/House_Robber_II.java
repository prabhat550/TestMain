package com.dp;

public class House_Robber_II {

	public static void main(String[] args) {

		int[] array = new int[] { 1, 2, 3, 1 };
		int result = rob(array);
		System.out.println(result);

	}

	public static int rob(int[] nums) {

		if (nums.length == 1)
			return nums[0];

		int rob1 = robHelper(nums, 0, nums.length - 1);
		int rob2 = robHelper(nums, 1, nums.length);
		return Math.max(rob1, rob2);

	}

	public static int robHelper(int[] nums, int start, int end) {

		int max = 0, prevOne = 0, prevTwo = 0;
		for (int i = start; i < end; i++) {
			max = Math.max(prevTwo + nums[i], prevOne);
			prevTwo = prevOne;
			prevOne = max;
		}
		return max;
	}

}
