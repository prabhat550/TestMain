package com.backtracking.recursion;

import java.util.ArrayList;
import java.util.List;

public class Combination_Sum_III {

	public static void main(String[] args) {

		List<List<Integer>> result = combinationSum3(3, 9);
		System.out.println(result);

	}

	public static List<List<Integer>> combinationSum3(int k, int n) {

		List<List<Integer>> result = new ArrayList<>();
		combinationSumHelper(result, new ArrayList<Integer>(), k, n, 1);
		return result;
	}

	private static void combinationSumHelper(List<List<Integer>> result, List<Integer> list, int k, int n, int index) {

		if (list.size() == k) {
			if (n == 0)
				result.add(new ArrayList<>(list));
			return;
		}

		for (int i = index; i <= 9; i++) {
			list.add(i);
			combinationSumHelper(result, list, k, n - i, i + 1);
			list.remove(list.size() - 1);
		}

	}

}
