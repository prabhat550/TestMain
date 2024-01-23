package com.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Minimum_Distance_Between_Source_And_Destination_Unweighted_Graph {

	public static void main(String[] args) {
		Minimum_Distance_Between_Source_And_Destination graph = new Minimum_Distance_Between_Source_And_Destination(6);
		graph.addEdge(0, 1);
		graph.addEdge(0, 3);
		graph.addEdge(1, 2);
		graph.addEdge(3, 4);
		graph.addEdge(2, 4);
		graph.addEdge(4, 5);
		int result = graph.getMinimumDistanceBetweenSourceAndDestination(0, 5);
		System.out.println(result);
	}

}

// This will work both for directed and undirected graph
class Minimum_Distance_Between_Source_And_Destination {

	List<List<Integer>> graph;
	boolean[] visited;

	Minimum_Distance_Between_Source_And_Destination(int nodes) {
		this.graph = new ArrayList<>();
		this.visited = new boolean[nodes];
		for (int i = 0; i < nodes; i++) {
			graph.add(i, new ArrayList<Integer>());
		}
	}

	public void addEdge(int a, int b) {
		graph.get(a).add(b);
		graph.get(b).add(a);
	}

	public int getMinimumDistanceBetweenSourceAndDestination(int source, int destination) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(source);
		visited[source] = true;
		int minDistance = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			while (size-- > 0) {
				Integer node = queue.poll();
				List<Integer> neighbourList = graph.get(node);
				for (int neighbour : neighbourList) {
					if (neighbour == destination) {
						return minDistance + 1;
					}
					if (!visited[neighbour]) {
						queue.add(neighbour);
						visited[neighbour] = true;
					}
				}
			}
			minDistance++;
		}
		return -1;
	}

}
