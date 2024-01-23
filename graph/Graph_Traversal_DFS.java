package com.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class Graph_Traversal_DFS {

	public static void main(String[] args) {

		Traversal_DFS dfs = new Traversal_DFS(8);
		dfs.addEdge(0, 1);
		dfs.addEdge(0, 2);
		dfs.addEdge(0, 3);
		dfs.addEdge(1, 4);
		dfs.addEdge(2, 4);
		dfs.addEdge(2, 5);
		dfs.addEdge(5, 6);
		dfs.addEdge(5, 7);
		List<Integer> result = dfs.dfsTraversal(0);
		System.out.println(result);

	}
}

class Traversal_DFS {

	private boolean[] visited;
	private List<List<Integer>> graph;
	private List<Integer> result;

	Traversal_DFS(int nodes) {
		this.visited = new boolean[nodes];
		this.graph = new ArrayList<>();
		this.result = new ArrayList<>();
		for (int i = 0; i < nodes; i++) {
			graph.add(i, new ArrayList<>());
		}
	}

	// Undirected Graph
	public void addEdge(int a, int b) {
		graph.get(a).add(b);
		graph.get(b).add(a);
	}

	public List<Integer> dfsTraversal(int start) {

		Stack<Integer> stack = new Stack<>();
		stack.add(start);
		visited[start] = true;
		while (!stack.isEmpty()) {
			int val = stack.pop();
			result.add(val);
			List<Integer> neighbourList = graph.get(val);
			for (int neighbour : neighbourList) {
				if (!visited[neighbour]) {
					stack.push(neighbour);
					visited[neighbour] = true;
				}
			}
		}
		return result;
	}
}

