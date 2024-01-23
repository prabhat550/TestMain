package com.two.pointer;

import java.util.HashMap;
import java.util.Map;

public class Two_Sum {

	// https://leetcode.com/problems/two-sum/
	public static void main(String[] args) {

		int[] nums = { 2, 7, 11, 15 };
		int target = 9;
		int[] result_Approach1 = twoSum_Approach1(nums, target);
		int[] result_Approach2 = twoSum_Approach2(nums, target);
		printArray(result_Approach1);
		printArray(result_Approach2);

	}

	// time complexity : O(n2)
	public static int[] twoSum_Approach1(int[] nums, int target) {
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if ((nums[i] + nums[j]) == target) {
					return new int[] { i, j };
				}
			}
		}
		return null;
	}

	// time complexity : O(n)
	public static int[] twoSum_Approach2(int[] nums, int target) {

		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			int complement = target - nums[i];
			if (map.containsKey(complement)) {
				return new int[] { map.get(complement), i };
			} else {
				map.put(nums[i], i);
			}
		}
		return new int[] {};
	}

	public static void printArray(int[] result) {
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + " ");
		}
		System.out.println();
	}
}
