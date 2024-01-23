package com.stack;

import java.util.Stack;

public class Next_Greater_Element_On_Right {

	public static void main(String[] args) {

		int[] nums = new int[] { 2, 5, 9, 3, 1, 12, 6, 8, 7 };
		int[] result = nextGreaterElementOnRight(nums);
		System.out.println(result);

	}

	// For greater problems, use a monotonically increasing stack (from top to bottom). 
	// If we need to pop smaller elements from the stack before pushing a new element.
	// For right we iterate with end of the array.
	public static int[] nextGreaterElementOnRight(int[] nums) {
		int[] nge = new int[nums.length];
		Stack<Integer> stack = new Stack<>();
		nge[nums.length - 1] = -1;
		stack.push(nums[nums.length - 1]);
		for (int i = nums.length - 2; i >= 0; i--) {
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
