package com.dp;

import java.util.LinkedList;
import java.util.Queue;

public class Jump_Game_III {

	public static void main(String[] args) {

		int[] array = new int[] { 4, 2, 3, 0, 3, 1, 2 };
		boolean result_Approach1 = canReach_Approach1(array, 5);
		System.out.println(result_Approach1);

		boolean result_Approach2 = canReach_Approach2(array, 5);
		System.out.println(result_Approach2);
	}

	// BFS Approach
	public static boolean canReach_Approach1(int[] arr, int start) {

		Queue<Integer> queue = new LinkedList<>();
		int n = arr.length;
		boolean[] visited = new boolean[n];

		queue.offer(start);

		while (!queue.isEmpty()) {

			int current_index = queue.poll();
			visited[current_index] = true;

			if (arr[current_index] == 0)
				return true;

			if (current_index + arr[current_index] < n && !visited[current_index + arr[current_index]]) {
				queue.offer(current_index + arr[current_index]);
			}
			if (current_index - arr[current_index] >= 0 && !visited[current_index - arr[current_index]]) {
				queue.offer(current_index - arr[current_index]);
			}

		}

		return false;
	}

	// DFS Approach
	public static boolean canReach_Approach2(int[] array, int start) {

		boolean[] visited = new boolean[array.length];

		return helperMethodDFS(array, start, visited);
	}

	private static boolean helperMethodDFS(int[] array, int start, boolean[] visited) {

		if (start >= array.length || start < 0 || visited[start]) {
			return false;
		}

		if (array[start] == 0)
			return true;
		visited[start] = true;

		return helperMethodDFS(array, start + array[start], visited)
				|| helperMethodDFS(array, start - array[start], visited);

	}

}
