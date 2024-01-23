package com.stack;

import java.util.Stack;

public class Next_Smaller_Element_On_Left {

	public static void main(String[] args) {
		
		int[] nums = new int[] { 2, 5, 9, 3, 1, 12, 6, 8, 7 };
		int[] result = nextSmallerElementOnLeft(nums);
		System.out.println(result);

	}
	
	// For smaller problems, use a monotonically decreasing stack (from top to bottom). 
	// If we need to pop greater elements from the stack before pushing a new element.
	// For left we iterate with start of the array.
	public static int[] nextSmallerElementOnLeft(int[] nums) {
		int[] nse = new int[nums.length];
		Stack<Integer> stack = new Stack<>();
		nse[0] = -1;
		stack.add(nums[0]);
		for (int i = 1; i < nums.length; i++) {
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
