package com.backtracking.recursion;

import java.util.ArrayList;
import java.util.List;

public class Permutations_I {

	public static void main(String[] args) {
		int[] nums = new int[] { 1, 2, 3 };

		List<List<Integer>> result_permute = permute(nums);
		System.out.println(result_permute);
	}

	public static List<List<Integer>> permute(int[] nums) {

		List<List<Integer>> result = new ArrayList<>();
		boolean[] visited = new boolean[nums.length];
		helper(result, nums, new ArrayList<Integer>(), visited);

		return result;
	}

	private static void helper(List<List<Integer>> result, int[] nums, List<Integer> list, boolean[] visited) {

		if (list.size() == nums.length) {
			result.add(new ArrayList<Integer>(list));
			return;
		}
		for (int i = 0; i < nums.length; i++) {
			if (visited[i])
				continue;
			visited[i] = true;
			list.add(nums[i]);
			helper(result, nums, list, visited);
			visited[i] = false;
			list.remove(list.size() - 1);
		}

	}

}
