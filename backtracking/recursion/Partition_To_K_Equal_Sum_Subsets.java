package com.backtracking.recursion;

import java.util.stream.IntStream;

public class Partition_To_K_Equal_Sum_Subsets {

	public static void main(String[] args) {

		int[] array = new int[] { 4, 1, 3, 2, 3, 5, 2 };
		boolean result_canPartitionKSubsets = canPartitionKSubsets(array, 4);
		System.out.println(result_canPartitionKSubsets);

	}

	public static boolean canPartitionKSubsets(int[] nums, int k) {
		int sum = IntStream.of(nums).sum();
		if (k == 0 || sum % k != 0) {
			return false;
		}
		return canPartitionKSubsetsHelper(0, nums, k, 0, sum / k, new boolean[nums.length]);
	}

	public static boolean canPartitionKSubsetsHelper(int index, int[] nums, int k, int partitionSum, int targetSum,
			boolean[] visited) {
		if (k == 1)
			return true;
		if (partitionSum == targetSum)
			return canPartitionKSubsetsHelper(0, nums, k - 1, 0, targetSum, visited);
		for (int i = 0; i < nums.length; i++) {
			if (!visited[i] && partitionSum < targetSum) {
				visited[i] = true;
				if (canPartitionKSubsetsHelper(i + 1, nums, k, partitionSum + nums[i], targetSum, visited))
					return true;
				visited[i] = false;
			}
		}

		return false;
	}

}
