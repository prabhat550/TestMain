package com.dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Jump_Game_IV {

	public static void main(String[] args) {

		int[] array = new int[] { 100, -23, -23, 404, 100, 23, 23, 23, 3, 404 };
		int result = minJumps(array);
		System.out.println(result);

	}

	public static int minJumps(int[] array) {

		Map<Integer, List<Integer>> map = new HashMap<>();
		int step = 0;
		int n = array.length;

		for (int i = 0; i < n; i++) {
			map.computeIfAbsent(array[i], a -> new ArrayList<>()).add(i);
		}
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(0);

		while (!queue.isEmpty()) {
			step++;
			int size = queue.size();
			for (int i = 0; i < size; i++) {

				int j = queue.poll();
				
				// Jump to j - 1;
				if (j - 1 >= 0 && map.containsKey(array[j - 1])) {
					queue.offer(j - 1);
				}
				// Jump to j + 1
				if (j + 1 < n && map.containsKey(array[j + 1])) {
					queue.offer(j + 1);
				}
				// Jump to k -> array[j] == array[k]
				if (map.containsKey(array[j])) {
					for (int k : map.get(array[j])) {
						if (k != j) {
							if (k == n - 1) {
								return step;
							}
							queue.offer(k);
						}
					}
				}
				map.remove(array[j]);
			}
		}

		return step;
	}

}


