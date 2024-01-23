package com.dp;

public class Maximum_Subarray {

	// https://leetcode.com/problems/maximum-subarray/
	// Kadane's Algorithm
	public static void main(String[] args) {

		int[] array = { -2, 1, -3, 4, -1, 5, 1, -5, 4 };
		// int result = maximumSubArray_ReturnSum(array);

		int[] result = maximumSubArray_ReturnArray(array);
		printArray(result);
		
	}
		

	public static int maximumSubArray_ReturnSum(int[] array) {
		int maxSumArray = array[0];
		int maxEndingHere = 0;

		for (int i = 0; i < array.length; i++) {
			maxEndingHere = maxEndingHere + array[i];
			if (maxSumArray < maxEndingHere) {
				maxSumArray = maxEndingHere;
			}
			if (maxEndingHere < 0) {
				maxEndingHere = 0;
			}
			
		}
		return maxSumArray;
	}

	public static int[] maximumSubArray_ReturnArray(int[] array) {
		int maxSumArray = array[0];
		int maxEndingHere = 0;
		int s = 0, start = 0, end = 0;
		for (int i = 0; i < array.length; i++) {
			maxEndingHere = maxEndingHere + array[i];
			if (maxSumArray < maxEndingHere) {
				maxSumArray = maxEndingHere;
				start = s;
				end = i;
			}
			if (maxEndingHere < 0) {
				maxEndingHere = 0;
				s = i + 1;
			}
		}
		int lengthOfTheResultArray = end - s + 1;
		int resultArray[] = new int[lengthOfTheResultArray];
		for (int i = 0; i < lengthOfTheResultArray; i++) {
			resultArray[i] = array[s];
			s++;
		}
		return resultArray;
	}

	public static void printArray(int[] array) {

		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}

	}

}



