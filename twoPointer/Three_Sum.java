package com.two.pointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Three_Sum {

	public static void main(String[] args) {

		int[] array = new int[] { -1, 0, 1, 2, -1, -4 };
		List<List<Integer>> result_threeSum = threeSum(array);
		System.out.println(result_threeSum);

	}

	public static List<List<Integer>> threeSum(int[] nums) {

		List<List<Integer>> result = new ArrayList<>();
		if (nums.length == 0 || nums == null)
			return result;

		Arrays.sort(nums);
		
		for (int i = 0; i < nums.length; i++) {
			if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
				int low = i + 1;
				int high = nums.length - 1;
				while (low < high) {
					int sum = nums[i] + nums[low] + nums[high];
					if (sum == 0) {
						result.add(Arrays.asList(nums[i], nums[low], nums[high]));
						while (low < high && nums[low] == nums[low + 1]) {
							low++;
						}
						while (low < high && nums[high] == nums[high - 1]) {
							high--;
						}
						low++;
						high--;
					} else if (sum > 0) {
						high--;
					} else {
						low++;
					}
				}
			}
		}
		return result;
	}

}
