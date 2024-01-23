package com.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Jump_Game_II {

	public static void main(String[] args) {

		int[] array = new int[] { 2, 3, 1, 1, 4 };

		int result_jump_Approach1 = jump_Approach1(array);
		System.out.println(result_jump_Approach1);

		int result_jump_Approach2 = jump_Approach2(array);
		System.out.println(result_jump_Approach2);

		int[] array_paths = new int[] { 3, 3, 0, 2, 1, 2, 4, 2, 0, 0 };
		List<String> result_printAllMinimumJumpPaths = printAllMinimumJumpPaths(array_paths);
		System.out.println(result_printAllMinimumJumpPaths);

	}

	// Traversing from the start of the array to the end of the array
	public static int jump_Approach1(int[] nums) {

		if (nums.length == 0 || nums == null)
			return 0;
		int[] dp = new int[nums.length];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;

		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[j] + j >= i) {
					dp[i] = Math.min(dp[i], dp[j] + 1);
				}
			}
		}
		return dp[nums.length - 1];
	}

	// Traversing from the end of the array to the start of the array
	public static int jump_Approach2(int[] nums) {

		Integer[] dp = new Integer[nums.length];
		dp[nums.length - 1] = 0;

		for (int i = nums.length - 2; i >= 0; i--) {
			int steps = nums[i];
			int min = Integer.MAX_VALUE;
			for (int j = 1; j <= steps && i + j < nums.length; j++) {
				if (dp[i + j] != null && dp[i + j] < min) {
					min = dp[i + j];
				}
			}
			if (min != Integer.MAX_VALUE)
				dp[i] = min + 1;
		}
		return dp[0];
	}

	// Print All Paths Minimum Jump
	public static List<String> printAllMinimumJumpPaths(int[] nums) {

		Integer[] dp = new Integer[nums.length];
		dp[nums.length - 1] = 0;

		for (int i = nums.length - 2; i >= 0; i--) {
			int steps = nums[i];
			int min = Integer.MAX_VALUE;

			for (int j = 1; j <= steps && i + j < nums.length; j++) {
				if (dp[i + j] != null && dp[i + j] < min) {
					min = dp[i + j];
				}
			}

			if (min != Integer.MAX_VALUE)
				dp[i] = min + 1;
		}

		List<String> allPaths = new ArrayList<>();
		Queue<Pair> queue = new LinkedList<>();
		queue.offer(new Pair(0, nums[0], dp[0], 0 + ""));

		while (!queue.isEmpty()) {
			Pair pair = queue.poll();

			if (pair.jumps == 0) {
				allPaths.add(pair.pathSoFar);
			}

			for (int j = 1; j <= pair.size && pair.index + j < nums.length; j++) {
				int current_index = pair.index + j;

				if (dp[current_index] != null && dp[current_index] == pair.jumps - 1) {
					queue.offer(new Pair(current_index, nums[current_index], dp[current_index],
							pair.pathSoFar + " -> " + current_index));
				}
			}
		}
		return allPaths;
	}
}

class Pair {

	int index;
	int size;
	int jumps;
	String pathSoFar;

	public Pair(int index, int size, int jumps, String pathSoFar) {
		super();
		this.index = index;
		this.size = size;
		this.jumps = jumps;
		this.pathSoFar = pathSoFar;
	}

}
