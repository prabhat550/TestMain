package com.two.pointer;

public class Squares_Of_A_Sorted_Array {

	public static void main(String[] args) {

		int[] nums = new int[] { -4, -1, 0, 3, 10 };
		int[] result = sortedSquares(nums);
		System.out.println(result);

	}

	public static int[] sortedSquares(int[] nums) {
		int low = 0;
		int high = nums.length - 1;
		int[] result = new int[nums.length];
		for (int i = nums.length - 1; i >= 0; i--) {
			if (Math.abs(nums[high]) > Math.abs(nums[low])) {
				result[i] = nums[high] * nums[high];
				high--;
			} else {
				result[i] = nums[low] * nums[low];
				low++;
			}
		}
		return result;
	}

}
