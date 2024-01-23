package com.two.pointer;

public class Sort_Colors {

	public static void main(String[] args) {

		int[] array = new int[] { 1, 0, 2, 1, 1, 0 };
		sortColors_Approach1(array);
		System.out.println(array);

	}

	// Dutch National Flag Problem
	// https://leetcode.com/problems/sort-colors/  int[] array = new int[] { 1, 0, 2, 1, 1, 0 };
	public static void sortColors_Approach1(int[] nums) {
		
		int start = 0;
		int end = nums.length - 1;
		int index = 0;
		while (index <= end) {
			if (nums[index] == 0) {
				nums[index] = nums[start];
				nums[start] = 0;
				index++;
				start++;
			} else if (nums[index] == 2) {
				nums[index] = nums[end];
				nums[end] = 2;
				end--;
			} else {
				index++;
			}
		}
		return;
	}

}
