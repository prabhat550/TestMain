package com.two.pointer;

public class Move_Zereos {

	public static void main(String[] args) {

		int[] nums = { 0, 1, 0, 3, 12 };
		//moveZeroes_Approach1(nums);
		moveZeroes_Approach2(nums);
		

	}

	// New array is created
	public static void moveZeroes_Approach1(int[] nums) {

		int[] result = new int[nums.length];
		int pointer = 0;

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0) {
				result[pointer] = nums[i];
				pointer++;
			}
		}
		nums = result;

	}

	// Operations on the same array
	public static void moveZeroes_Approach2(int[] nums) {

		int pointer = 0;

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0) {
				nums[pointer] = nums[i];
				pointer++;
			}
		}
		
		while (pointer < nums.length) {
			nums[pointer] = 0;
			pointer++;
		}
		
		printArray(nums);
	}

	public static void printArray(int[] array) {

		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}

	}

}
