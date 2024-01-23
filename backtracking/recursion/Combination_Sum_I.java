package com.backtracking.recursion;

import java.util.ArrayList;
import java.util.List;

public class Combination_Sum_I {

	public static void main(String[] args) {

		int[] array = new int[] { 2, 3, 6, 7 };
		List<List<Integer>> result = combinationSum(array, 7);
		System.out.println(result);
		
		
	}

	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> result = new ArrayList<>();
		combinationSumHelper(result, candidates, new ArrayList<Integer>(), target, 0);
		return result;
	}

	private static void combinationSumHelper(List<List<Integer>> result, int[] candidates, List<Integer> list,
			int target, int index) {
		if (target == 0) {
			result.add(new ArrayList<Integer>(list));
			return;
		}
		for (int i = index; i < candidates.length; i++) {
			if (candidates[i] <= target) {
				list.add(candidates[i]);
				combinationSumHelper(result, candidates, list, target - candidates[i], index);
				list.remove(list.size() - 1);
			}
		}
	}

}
