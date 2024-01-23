package com.stack;

import java.util.Stack;

public class Next_Greater_Element_II {

	public static void main(String[] args) {

		int[] nums = new int[] { 1, 2, 1 };
		int[] result = nextGreaterElements(nums);
		System.out.println(result);

	}

	public static int[] nextGreaterElements(int[] nums) {
		int n = nums.length;
		int[] nge = new int[n];
		Stack<Integer> stack = new Stack<>();
		for (int i = n - 2; i >= 0; i--) {
			while (!stack.isEmpty() && nums[i] >= stack.peek()) {
				stack.pop();
			}
			stack.push(nums[i]);
		}
		for (int i = n - 1; i >= 0; i--) {
			while (!stack.isEmpty() && nums[i] >= stack.peek()) {
				stack.pop();
			}
			if (stack.isEmpty()) {
				nge[i] = -1;
			} else {
				nge[i] = stack.peek();
			}
			stack.push(nums[i]);
		}
		return nge;
	}

}
