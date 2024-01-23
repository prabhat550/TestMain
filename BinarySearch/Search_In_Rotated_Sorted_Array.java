package com.binary.search;

public class Search_In_Rotated_Sorted_Array {

	public static void main(String[] args) {

		int[] nums = new int[] { 4, 5, 6, 7, 0, 1, 2 };
		int result_search_Approach1 = search_Approach1(nums, 0);
		System.out.println(result_search_Approach1);
		
		int result_search_Approach2 = search_Approach2(nums, 0);
		System.out.println(result_search_Approach2);

	}

	public static int search_Approach1(int[] nums, int target) {

		if (nums.length == 0 || nums == null) {
			return -1;
		}

		int left = 0;
		int right = nums.length - 1;

		while (left < right) {
			int midpoint = left + (right - left) / 2;
			if (nums[midpoint] > nums[right]) {
				left = midpoint + 1;
			} else {
				right = midpoint;
			}
		}

		int start = left;
		left = 0;
		right = nums.length - 1;

		if (target >= nums[start] && target <= nums[right]) {
			left = start;
		} else {
			right = start;
		}

		while (left <= right) {
			int midpoint = left + (right - left) / 2;

			if (nums[midpoint] == target) {
				return midpoint;
			} else if (target > nums[midpoint]) {
				left = midpoint + 1;
			} else {
				right = midpoint - 1;
			}
		}

		return -1;
	}

	public static int search_Approach2(int[] nums, int target) {

		int left = 0;
		int right = nums.length - 1;

		while (left <= right) {

			int mid = left + (right - left) / 2;
			if (nums[mid] == target) {
				return mid;
			} else if (nums[left] <= nums[mid]) {
				// lower to mid part of array is sorted
				if (target >= nums[left] && target < nums[mid]) {
					right = mid - 1;
				} else {
					left = mid + 1;
				}
			} else if (nums[right] >= nums[mid]) {
				// mid to right part of array is sorted
				if (target > nums[mid] && target <= nums[right]) {
					left = mid + 1;
				} else {
					right = mid - 1;
				}
			}
		}
		return -1;
	}

}
