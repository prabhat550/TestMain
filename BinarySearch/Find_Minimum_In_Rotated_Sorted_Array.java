package com.binary.search;

public class Find_Minimum_In_Rotated_Sorted_Array {

	public static void main(String[] args) {

		int[] array = new int[] { 4, 5, 6, 7, 8, 0, 1, 2, 3 };
		int result_findMin = findMin(array);
		System.out.println(result_findMin);

	}

	public static int findMin(int[] nums) {

		if (nums.length == 0 || nums == null)
			return -1;

		int low = 0;
		int high = nums.length - 1;

		if (nums[low] <= nums[high])
			return nums[0];

		while (low <= high) {

			int mid = low + (high - low) / 2;

			if (nums[mid] > nums[mid + 1]) {
				return nums[mid + 1];
			} else if (nums[mid] < nums[mid - 1]) {
				return nums[mid];
			} else if (nums[low] < nums[mid]) {
				low = mid + 1;
			} else if (nums[high] > nums[mid]) {
				high = mid - 1;
			}
		}

		return -1;
	}

}
