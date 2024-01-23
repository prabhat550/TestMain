package com.dp;

public class Jump_Game {

	public static void main(String[] args) {

		int[] array = new int[] { 2, 3, 1, 1, 4 };
		boolean result_canJump = canJump(array);
		System.out.println(result_canJump);

	}

	public static boolean canJump(int[] nums) {

		if (nums.length == 0)
			return false;
		
		int lastGoodIndex = nums.length - 1;
		for (int i = nums.length - 2; i >= 0; i--) {
			if (nums[i] + i >= lastGoodIndex) {
				lastGoodIndex = i;
			}
		}

		return lastGoodIndex == 0 ? true : false;
	}

}
