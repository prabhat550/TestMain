package com.backtracking.recursion;

import java.util.ArrayList;
import java.util.List;

public class Combinations {

	public static void main(String[] args) {

		List<List<Integer>> result = combine(4, 2);
		System.out.println(result);

	}

	public static List<List<Integer>> combine(int n, int k) {

		List<List<Integer>> result = new ArrayList<>();
		combinationHelper(result, new ArrayList<Integer>(), n, k, 1);
		return result;
	}

	public static void combinationHelper(List<List<Integer>> result, List<Integer> list, int n, int k, int index) {

		if (list.size() == k) {
			result.add(new ArrayList<>(list));
			return;
		}

		for (int i = index; i <= n; i++) {

			list.add(i);
			combinationHelper(result, list, n, k, i + 1);
			list.remove(list.size() - 1);

		}

	}

}
