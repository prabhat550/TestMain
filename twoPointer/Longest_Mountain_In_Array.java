package com.two.pointer;

public class Longest_Mountain_In_Array {

	public static void main(String[] args) {

		int[] array = new int[] { 2, 1, 4, 7, 3, 2, 5 };
		int result_longestMountain_Approach_1 = longestMountain_Approach_1(array);
		System.out.println(result_longestMountain_Approach_1);

		int result_longestMountain_Approach_2 = longestMountain_Approach_2(array);
		System.out.println(result_longestMountain_Approach_2);

	}

	// Approach 1 - Going through the whole mountain the peak and the valley
	public static int longestMountain_Approach_1(int[] arr) {

		if (arr.length < 3)
			return 0;

		int result = 0;
		int i = 0;
		boolean peak = false;
		boolean valley = false;
		while (i < arr.length - 1) {

			if (arr[i + 1] > arr[i]) {

				int start = i;
				while (i < arr.length - 1 && arr[i + 1] > arr[i]) {
					i++;
					peak = true;
				}
				while (i < arr.length - 1 && arr[i + 1] < arr[i]) {
					i++;
					valley = true;
				}
				if (peak && valley) {
					result = Math.max(result, i - start + 1);
				}
			} else {
				i++;
			}
		}

		return result;
	}

	// Approach 2 - Starting at the peak element
	public static int longestMountain_Approach_2(int[] arr) {

		if (arr.length < 3)
			return 0;

		int result = 0;
		int n = arr.length;

		for (int i = 0; i < n - 1; i++) {

			if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
				int count = 1;
				int j = i;
				while (j > 0 && arr[j] > arr[j - 1]) {
					count++;
					j--;
				}
				while (i < n - 1 && arr[i] > arr[i + 1]) {
					count++;
					i++;
				}
				result = Math.max(count, result);
			}
		}
		return result;
	}

}
