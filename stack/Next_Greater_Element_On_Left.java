package com.stack;

import java.util.Stack;

public class Next_Greater_Element_On_Left {

	public static void main(String[] args) {

		int[] nums = new int[] { 2, 5, 9, 3, 1, 12, 6, 8, 7 };
		int[] result = nextGreaterElementOnLeft(nums);
		System.out.println(result);

	}

	// For greater problems, use a monotonically increasing stack (from top to bottom). 
	// If we need to pop smaller elements from the stack before pushing a new element.
	// For left we iterate with start of the array.
	public static int[] nextGreaterElementOnLeft(int[] nums) {
		int[] nge = new int[nums.length];
		Stack<Integer> stack = new Stack<>();
		nge[0] = -1;
		stack.push(nums[0]);
		for (int i = 1; i < nums.length; i++) {
			while (stack.isEmpty() && nums[i] >= stack.peek()) {
				stack.pop();
			}
			if (stack.isEmpty()) {
				nge[i] = -1;
			} else {
				nge[i] = stack.peek();
			}
			stack.push(nge[i]);
		}
		return nge;
	}

}
