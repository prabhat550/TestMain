package com.two.pointer;

public class Running_Sum_Of_1d_Array {

	public static void main(String[] args) {

		int[] nums = new int[] { 1, 2, 3, 4 };
		int[] result = runningSum(nums);
		System.out.println(result);

	}

	public static int[] runningSum(int[] nums) {
		if (nums == null || nums.length == 0)
			return nums;
		for (int i = 1; i < nums.length; i++) {
			nums[i] += nums[i - 1];
		}
		return nums;
	}

}
