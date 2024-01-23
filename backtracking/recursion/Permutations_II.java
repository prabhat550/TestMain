package com.backtracking.recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Permutations_II {

	public static void main(String[] args) {

		int[] nums = new int[] { 1, 1, 2 };

		List<List<Integer>> result_permute = permuteUnique(nums);
		System.out.println(result_permute);

	}

	public static List<List<Integer>> permuteUnique(int[] nums) {

		List<List<Integer>> result = new ArrayList<>();

		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (!map.containsKey(nums[i])) {
				map.put(nums[i], 1);
			} else {
				map.put(nums[i], map.get(nums[i]) + 1);
			}
		}
		permutation(result, map, nums, new ArrayList<>());
		return result;

	}

	public static void permutation(List<List<Integer>> result, HashMap<Integer, Integer> map, int[] nums,
			List<Integer> list) {
		if (list.size() == nums.length) {
			result.add(new ArrayList<>(list));
			return;
		}
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			int key = entry.getKey();
			int value = entry.getValue();
			if (value == 0)
				continue;
			list.add(key);
			map.put(key, value - 1);
			permutation(result, map, nums, list);
			list.remove(list.size() - 1);
			map.put(key, value);
		}
	}

}
