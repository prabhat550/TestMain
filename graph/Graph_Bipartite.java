package com.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class Graph_Bipartite {

	public static void main(String[] args) {

		// int[][] graph = new int[][] { { 1, 2, 3 }, { 0, 2 }, { 0, 1, 3 }, { 0, 2 } };
		int[][] graph = new int[][] { { 1, 3 }, { 0, 2 }, { 1, 3 }, { 0, 2 } };
		boolean result = isBipartite(graph);
		System.out.println(result);

	}

	public static boolean isBipartite(int[][] graph) {
		
		int n = graph.length;
		List<List<Integer>> adjList = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			adjList.add(i, new ArrayList<Integer>());
		}
		for (int i = 0; i < n; i++) {
			List<Integer> neighbours = Arrays.stream(graph[i]).boxed().collect(Collectors.toList());
			adjList.get(i).addAll(neighbours);
		}
		int[] colours = new int[n];
		Arrays.fill(colours, -1);
		for (int i = 0; i < n; i++) {
			if (colours[i] == -1) {
				if (!bfsBipartiteVerification(adjList, i, colours)) {
					return false;
				}
			}
		}
		return true;
	}

	private static boolean bfsBipartiteVerification(List<List<Integer>> adjList, int node, int[] colours) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(node);
		colours[node] = 1;
		while (!queue.isEmpty()) {
			int n = queue.poll();
			List<Integer> neighbours = adjList.get(n);
			for (int neighbour : neighbours) {
				if (colours[neighbour] == -1) {
					colours[neighbour] = 1 - colours[n];
					queue.add(neighbour);
				}
				if (colours[neighbour] == colours[n]) {
					return false;
				}
			}
		}
		return true;
	}

}
