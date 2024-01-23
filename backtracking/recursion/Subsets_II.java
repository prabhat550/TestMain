package com.backtracking.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets_II {

	public static void main(String[] args) {

		int[] array = new int[] { 1, 2, 2 };
		List<List<Integer>> result_subsetsWithDup = subsetsWithDup(array);
		System.out.println(result_subsetsWithDup);

	}

	public static List<List<Integer>> subsetsWithDup(int[] nums) {

		List<List<Integer>> result = new ArrayList<>();
		Arrays.sort(nums);
		getSubsets(result, nums, new ArrayList<Integer>(), 0);

		return result;

	}

	public static void getSubsets(List<List<Integer>> result, int[] nums, List<Integer> list, int index) {

		result.add(new ArrayList<Integer>(list));

		for (int i = index; i < nums.length; i++) {

			if (i > index && nums[i - 1] == nums[i])
				continue;

			list.add(nums[i]);
			getSubsets(result, nums, list, i + 1);
			list.remove(list.size() - 1);

		}
	}

}
