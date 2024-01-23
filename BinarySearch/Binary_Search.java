package com.binary.search;

public class Binary_Search {

	public static void main(String[] args) {

		int[] nums = new int[] { 2, 5, 8, 12, 16, 23, 38, 56, 72, 91 };
		int result_Iterative = binarSearch_Iterative(nums, 23);
		System.out.println(result_Iterative);

		int result_Recursive = binarSearch_Recursive(nums, 23, 0, nums.length - 1);
		System.out.println(result_Recursive);

	}

	public static int binarSearch_Iterative(int[] nums, int num) {
		int low = 0;
		int high = nums.length - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (nums[mid] == num) {
				return mid;
			} else if (nums[mid] > num) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return -1;
	}

	public static int binarSearch_Recursive(int[] nums, int num, int low, int high) {
		if (high >= low) {
			int mid = low + (high - low) / 2;
			if (nums[mid] == num) {
				return mid;
			} else if (nums[mid] > num) {
				return binarSearch_Recursive(nums, num, low, mid - 1);
			} else {
				return binarSearch_Recursive(nums, num, mid + 1, high);
			}
		}
		return -1;
	}

}
