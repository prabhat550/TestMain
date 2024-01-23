package com.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Source_To_Destination {

	public static void main(String[] args) {
		
		Graph_Source_To_Destination sourceToDestination = new Graph_Source_To_Destination(7);
		sourceToDestination.addEdge(0, 1);
		sourceToDestination.addEdge(1, 2);
		sourceToDestination.addEdge(2, 0);
		sourceToDestination.addEdge(3, 2);
		sourceToDestination.addEdge(2, 4);
		boolean result = sourceToDestination.sourceToDestination(0, 2);
        // boolean result = sourceToDestination.sourceToDestination(0, 3);
		System.out.println(result);

	}
}

class Graph_Source_To_Destination {

	private boolean[] visited;
	private List<List<Integer>> graph;

	public Graph_Source_To_Destination(int nodes) {
		this.graph = new ArrayList<>();
		this.visited = new boolean[nodes];
		for (int i = 0; i < nodes; i++) {
			graph.add(i, new ArrayList<>());
		}
	}

	// Directed Graph
	public void addEdge(int a, int b) {
		this.graph.get(a).add(b);
	}

	public boolean sourceToDestination(int source, int destination) {
		
		if (source == destination)
			return true;
		
		Stack<Integer> stack = new Stack<>();
		stack.add(source);
		visited[source] = true;
		while (!stack.isEmpty()) {
			int val = stack.pop();
			List<Integer> neighbourList = graph.get(val);
			for (int neighbour : neighbourList) {
				if (neighbour == destination)
					return true;
				if (!visited[neighbour]) {
					stack.add(neighbour);
					visited[neighbour] = true;
				}
			}

		}
		return visited[destination];
	}
	
}
