package com.two.pointer;

import java.util.Arrays;

public class Three_Sum_Closet {

	public static void main(String[] args) {

		int[] array = new int[] { -1, 2, 1, -4 };
		int result_threeSumClosest = threeSumClosest(array, 1);
		System.out.println(result_threeSumClosest);

	}

	public static int threeSumClosest(int[] nums, int target) {

		int result = 0;
		if (nums.length == 0 || nums == null)
			return 0;
		Arrays.sort(nums);
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < nums.length; i++) {
			if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
				int low = 0;
				int high = nums.length - 1;
				int sum = nums[i] + nums[low] + nums[high];
				if (sum == target)
					return sum;
				int diff = Math.abs(sum - target);
				if (diff < min) {
					min = diff;
					result = diff;
				}
				if (sum < target) {
					low++;
				}
				if (sum > target) {
					high--;
				}
			}
		}
		return result;
	}

}
