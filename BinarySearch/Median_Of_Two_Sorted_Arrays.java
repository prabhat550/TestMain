package com.binary.search;

public class Median_Of_Two_Sorted_Arrays {

	public static void main(String[] args) {

		int[] array_1 = new int[] { 3, 5, 7, 10, 15 };
		int[] array_2 = new int[] { 2, 4, 12 };
		double result_findMedianSortedArrays = findMedianSortedArrays(array_1, array_2);
		System.out.println(result_findMedianSortedArrays);	

	}

	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

		int[] result = new int[nums1.length + nums2.length];
		// Merge Two Sorted Array
		int i = 0, j = 0;
		int index = 0;

		while (i < nums1.length && j < nums2.length) {
			if (nums1[i] < nums2[j]) {
				result[index++] = nums1[i++];
			} else {
				result[index++] = nums2[j++];
			}
		}
		while (i < nums1.length) {
			result[index++] = nums1[i++];
		}
		while (j < nums2.length) {
			result[index++] = nums2[j++];
		}
		int n = result.length;
		double resultMedian = 0.0;
		if (n % 2 == 0) {
			resultMedian = (result[n / 2] + result[(n / 2) - 1]) / 2.0;
		} else {
			resultMedian = result[n / 2];
		}
		return resultMedian;
	}

}
