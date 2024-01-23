package com.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Minimum_Height_Trees {

	public static void main(String[] args) {

		int n = 4;
		int[][] edges = new int[][] { { 1, 0 }, { 1, 2 }, { 1, 3 } };
		List<Integer> result = findMinHeightTrees(n, edges);
		System.out.println(result);

	}

	public static List<Integer> findMinHeightTrees(int n, int[][] edges) {
		List<List<Integer>> graph = new ArrayList<>();
		Map<Integer, Integer> incomingDegree = new HashMap<>();
		Queue<Integer> sourceQueue = new LinkedList<>();
		List<Integer> topologicalSortList = new ArrayList<>();
		if (n <= 0) {
			return topologicalSortList;
		}
		if (n == 1) {
			topologicalSortList.add(0);
			return topologicalSortList;
		}
		for (int i = 0; i < n; i++) {
			graph.add(i, new ArrayList<Integer>());
			incomingDegree.put(i, 0);
		}
		int m = edges.length;
		for (int i = 0; i < m; i++) {
			graph.get(edges[i][0]).add(edges[i][1]);
			graph.get(edges[i][1]).add(edges[i][0]);
			incomingDegree.put(edges[i][0], incomingDegree.getOrDefault(edges[i][0], 0) + 1);
			incomingDegree.put(edges[i][1], incomingDegree.getOrDefault(edges[i][1], 0) + 1);
		}
		for (Map.Entry<Integer, Integer> entry : incomingDegree.entrySet()) {
			if (entry.getValue() == 1) {
				sourceQueue.add(entry.getKey());
			}
		}
		while (n > 2) {
			int size = sourceQueue.size();
			n -= size;
			while (size-- > 0) {
				int val = sourceQueue.poll();
				List<Integer> neighbourList = graph.get(val);
				for (int neighbour : neighbourList) {
					incomingDegree.put(neighbour, incomingDegree.get(neighbour) - 1);
					if (incomingDegree.get(neighbour) == 1) {
						sourceQueue.add(neighbour);
					}
				}
			}
		}
		topologicalSortList.addAll(sourceQueue);
		return topologicalSortList;
	}

}
