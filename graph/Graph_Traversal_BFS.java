package com.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Graph_Traversal_BFS {

	public static void main(String[] args) {

		BFS_Traversal bfs = new BFS_Traversal(8);
		bfs.addEdge(0, 1);
		bfs.addEdge(0, 2);
		bfs.addEdge(0, 3);
		bfs.addEdge(1, 4);
		bfs.addEdge(2, 4);
		bfs.addEdge(2, 5);
		bfs.addEdge(5, 6);
		bfs.addEdge(5, 7);
		List<Integer> result = bfs.bfsTraversal(0);
		System.out.println(result);

	}
}


class BFS_Traversal {

	private boolean[] visited;
	private List<List<Integer>> graph;
	private List<Integer> result;

	BFS_Traversal(int nodes) {
		this.visited = new boolean[nodes];
		this.graph = new ArrayList<>();
		this.result = new ArrayList<>();
		for (int i = 0; i < nodes; i++) {
			graph.add(i, new ArrayList<>());
		}
	}
	
	// Undirected Graph
	public void addEdge(int a, int b) {
		this.graph.get(a).add(b);
		this.graph.get(b).add(a);
	}

	public List<Integer> bfsTraversal(int start) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);
		visited[start] = true;
		while (!queue.isEmpty()) {
			int val = queue.poll();
			List<Integer> neighbourList = graph.get(val);
			for (int neighbour : neighbourList) {
				if (!visited[neighbour]) {
					queue.add(neighbour);
					visited[neighbour] = true;
				}
			}
		}
		return result;
	}

}


