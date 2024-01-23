package com.two.pointer;

public class Trapping_Rain_Water {

	public static void main(String[] args) {

		int[] height = new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		// Prefix And Suffix Approach
		int result_Approach1 = trap_Approach1(height);
		System.out.println(result_Approach1);

		// Two Pointer Approach
		int result_Approach2 = trap_Approach2(height);
		System.out.println(result_Approach2);

	}

	// Prefix : To Store Maximum On Left
	// Suffix : To Store Maximum On Right
	public static int trap_Approach1(int[] height) {

		int result = 0;
		if (height.length == 0)
			return result;
		int n = height.length;
		int[] prefix = new int[n];
		int[] suffix = new int[n];
		// Prefix
		prefix[0] = height[0];
		for (int i = 1; i < height.length; i++) {
			prefix[i] = Math.max(prefix[i - 1], height[i]);
		}
		// Suffix
		suffix[n - 1] = height[n - 1];
		for (int i = n - 2; i >= 0; i--) {
			suffix[i] = Math.max(suffix[i + 1], height[i]);
		}
		for (int i = 0; i < height.length; i++) {
			result += Math.min(prefix[i], suffix[i]) - height[i];
		}
		return result;
	}

	// Two Pointer Approach
	public static int trap_Approach2(int[] height) {

		int result = 0;

		return result;
	}

}
