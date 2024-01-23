package com.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Course_Schedule_I {

	public static void main(String[] args) {

		int numCourses = 4;
		int[][] prerequisites = new int[][] { { 1, 0 }, { 2, 1 }, { 3, 2 } };
		
//		int numCourses = 5;
//		int[][] prerequisites = new int[][] { { 1, 2 }, { 4, 3 }, { 2, 4 }, { 4, 1 } };
		
		boolean result = canFinish(numCourses, prerequisites);
		System.out.println(result);

	}

	public static boolean canFinish(int numCourses, int[][] prerequisites) {
		List<List<Integer>> graph = new ArrayList<>();
		Map<Integer, Integer> incomingDegree = new HashMap<>();
		Queue<Integer> sourceQueue = new LinkedList<>();
		List<Integer> topologicalSortList = new ArrayList<>();
		for (int i = 0; i < numCourses; i++) {
			graph.add(i, new ArrayList<>());
			incomingDegree.put(i, 0);
		}
		int m = prerequisites.length;
		for (int i = 0; i < m; i++) {
			graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
			incomingDegree.put(prerequisites[i][0], incomingDegree.getOrDefault(prerequisites[i][0], 0) + 1);
		}
		for (Map.Entry<Integer, Integer> entry : incomingDegree.entrySet()) {
			if (entry.getValue() == 0) {
				sourceQueue.offer(entry.getKey());
			}
		}
		while (!sourceQueue.isEmpty()) {
			int val = sourceQueue.poll();
			topologicalSortList.add(val);
			List<Integer> neighbourList = graph.get(val);
			for (int neighbour : neighbourList) {
				incomingDegree.put(neighbour, incomingDegree.get(neighbour) - 1);
				if (incomingDegree.get(neighbour) == 0) {
					sourceQueue.add(neighbour);
				}
			}
		}
		if (topologicalSortList.size() == numCourses)
			return true;
		return false;
	}

}
