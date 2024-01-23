package com.backtracking.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combination_Sum_II {

	public static void main(String[] args) {

		int[] array = new int[] { 10, 1, 2, 7, 6, 1, 5 };
		List<List<Integer>> result = combinationSum2(array, 8);
		System.out.println(result);

	}

	public static List<List<Integer>> combinationSum2(int[] candidates, int target) {

		List<List<Integer>> result = new ArrayList<>();
		Arrays.sort(candidates);
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

			if (i > index && candidates[i - 1] == candidates[i]) 
				continue;
			
			if(target - candidates[i] < 0) 
				break;
			
			list.add(candidates[i]);
			combinationSumHelper(result, candidates, list, target - candidates[i], i + 1);
			list.remove(list.size() - 1);

		}

	}

}
