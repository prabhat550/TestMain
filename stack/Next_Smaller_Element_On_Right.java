package com.stack;

import java.util.Stack;

public class Next_Smaller_Element_On_Right {

	public static void main(String[] args) {

		int[] nums = new int[] { 2, 5, 9, 3, 1, 12, 6, 8, 7 };
		int[] result = nextSmallerElementOnRight(nums);
		System.out.println(result);

	}

	// For smaller problems, use a monotonically decreasing stack (from top to bottom). 
	// If we need to pop greater elements from the stack before pushing a new element.
	// For right we iterate with end of the array.
	public static int[] nextSmallerElementOnRight(int[] nums) {
		int[] nse = new int[nums.length];
		Stack<Integer> stack = new Stack<>();
		nse[nums.length - 1] = -1;
		stack.push(nums[nums.length - 1]);
		for (int i = nums.length - 2; i >= 0; i--) {
			while (!stack.isEmpty() && stack.peek() >= nums[i]) {
				stack.pop();
			}
			if (stack.isEmpty()) {
				nse[i] = -1;
			} else {
				nse[i] = stack.peek();
			}
			stack.push(nums[i]);
		}
		return nse;
	}

}
