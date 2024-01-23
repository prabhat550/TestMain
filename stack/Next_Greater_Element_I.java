package com.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Next_Greater_Element_I {

	public static void main(String[] args) {

		int[] nums1 = new int[] { 4, 1, 2 };
		int[] nums2 = new int[] { 1, 3, 4, 2 };
		int[] result = nextGreaterElement(nums1, nums2);
		System.out.println(result);

	}

	public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
		int[] ngr = nextGreaterElementOnRight(nums2);
		int[] ans = new int[nums1.length];
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums2.length; i++) {
			map.put(nums2[i], ngr[i]);
		}
		for (int i = 0; i < nums1.length; i++) {
			ans[i] = map.get(nums1[i]);
		}
		return ans;
	}

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
