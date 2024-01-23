package com.binary.search;

public class Find_First_And_Last_Position_Of_Element_In_Sorted_Array {

	public static void main(String[] args) {

		int[] array = new int[] { 5, 7, 7, 8, 8, 8, 8, 8, 10 };
		int[] result_searchRange = searchRange(array, 8);
		System.out.println(result_searchRange);

	}

	public static int[] searchRange(int[] nums, int target) {

		int[] result = new int[2];
		int start = 0;
		int end = nums.length - 1;

		// find first index in array
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (nums[mid] == target) {
				result[0] = mid;
				end = mid - 1;
			} else if (nums[mid] < target) {
				start = mid + 1;
			} else if (nums[mid] > target) {
				end = mid - 1;
			}
		}
		start = 0;
		end = nums.length - 1;
		
		// find last index in array
		while (start < end) {
			int mid = start + (end - start) / 2;
			if (nums[mid] == target) {
				result[1] = mid;
				start = mid + 1;
			} else if (nums[mid] < target) {
				start = mid + 1;
			} else if (nums[mid] > target) {
				end = mid - 1;
			}
		}
		return result;
	}

}
