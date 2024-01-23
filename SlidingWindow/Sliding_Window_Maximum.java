package com.sliding.window;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Sliding_Window_Maximum {

	public static void main(String[] args) {

		int[] nums = new int[] { 1, 3, -1, -3, 5, 3, 6, 7 };
		int k = 3;
		
		// int[] result_BruteForce = maxSlidingWindow_BruteForce(nums, k);
		// System.out.println(result_BruteForce); // [3, 3, 5, 5, 6, 7]

		int[] result_OptimizedApproach = maxSlidingWindow_OptimizedApproach(nums, k);
		System.out.println(result_OptimizedApproach); // [4, 4, 6, 6, 7, 8]

	}

	public static int[] maxSlidingWindow_BruteForce(int[] nums, int k) {
		if (nums.length == 0 || nums.length < k)
			return new int[0];
		List<Integer> result = new ArrayList<>();
		for (int i = 0; i <= nums.length - k; i++) {
			int max = Integer.MIN_VALUE;
			for (int j = i; j <= i + k - 1; j++) {
				max = Math.max(max, nums[j]);
			}
			result.add(max);
		}
		return result.stream().mapToInt(Integer::intValue).toArray();
	}

	// Next Greater Element - Monotonic Stack
	public static int[] maxSlidingWindow_OptimizedApproach(int[] nums, int k) {
		if (nums.length == 0 || nums.length < k)
			return new int[0];
		List<Integer> result = new ArrayList<>();
		Stack<Integer> stack = new Stack<>();
		int[] nge = new int[nums.length];
		stack.push(nums.length - 1);
		nge[nums.length - 1] = nums.length;
		for (int i = nums.length - 2; i >= 0; i--) {
			while (!stack.isEmpty() && nums[i] >= nums[stack.peek()]) {
				stack.pop();
			}
			if (stack.isEmpty()) {
				nge[i] = nums.length;
			} else {
				nge[i] = stack.peek();
			}
			stack.push(i);
		}
		for (int i = 0; i <= nums.length - k; i++) {
			int j = i;
			while (nge[j] < i + k) {
				j = nge[j];
			}
			result.add(nge[j]);
		}
		return result.stream().mapToInt(Integer::intValue).toArray();
	}

}
