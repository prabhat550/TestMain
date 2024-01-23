package com.dp;

public class Jump_Game_I {

	public static void main(String[] args) {

		int[] array = new int[] { 2, 3, 1, 1, 4 };
		boolean result_canJump = canJump(array);
		System.out.println(result_canJump);

	}

	public static boolean canJump(int[] nums) {

		int reach = 0;
		for (int i = 0; i <= reach; i++) {
			reach = Math.max(reach, nums[i] + i);
			if (reach >= nums.length - 1) {
				return true;
			}
		}
		return false;
	}

}
