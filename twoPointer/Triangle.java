package com.two.pointer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Triangle {

	// triangle=[[2],[3,4],[6,5,7],[4,1,8,3]]
	// https://leetcode.com/problems/triangle/
	public static void main(String[] args) {

		List<Integer> level1 = new ArrayList<>();
		Collections.addAll(level1, 2);

		List<Integer> level2 = new ArrayList<>();
		Collections.addAll(level2, 3, 4);

		List<Integer> level3 = new ArrayList<>();
		Collections.addAll(level3, 6, 5, 7);

		List<Integer> level4 = new ArrayList<>();
		Collections.addAll(level4, 4, 1, 8, 3);

		List<List<Integer>> triangle = new ArrayList<>();
		Collections.addAll(triangle, level1, level2, level3, level4);

		int result = minimumTotal(triangle);
		System.out.println(result);

	}

	public static int minimumTotal(List<List<Integer>> triangle) {

		int sum = 0;
		for (int i = 0; i < triangle.size(); i++) {
			int minValueFromList = minimumValueFromList(triangle.get(i));
			sum = sum + minValueFromList;
		}
		return sum;

	}

	public static int minimumValueFromList(List<Integer> list) {
		int value = Integer.MAX_VALUE;
		for (int i = 0; i < list.size(); i++) {
			if (value > list.get(i)) {
				value = list.get(i);
			}
		}

		return value;
	}

}
