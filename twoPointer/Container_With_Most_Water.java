package com.two.pointer;

public class Container_With_Most_Water {

	public static void main(String[] args) {

		int[] array = new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
		int result = maxArea(array);
		System.out.println(result);

	}

	public static int maxArea(int[] height) {

		int result = 0;
		if (height.length == 0 || height == null)
			return result;
		int l = 0;
		int r = height.length - 1;
		while (l < r) {
			int lh = height[l];
			int rh = height[r];
			int h = Math.min(lh, rh);
			result = Math.max((r - l) * h, result);
			if (lh > rh) {
				r--;
			} else {
				l++;
			}
		}
		return result;
	}

}
