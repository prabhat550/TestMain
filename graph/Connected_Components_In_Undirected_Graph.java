package com.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Connected_Components_In_Undirected_Graph {

	public static void main(String[] args) {

		int nodes = 7;
		Connected_Component_Graph graph = new Connected_Component_Graph(nodes);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 3);
		graph.addEdge(4, 5);
		graph.addEdge(4, 6);
		int result = graph.numberOfConnectedComponent();
		System.out.println(result);

	}

}

class Connected_Component_Graph {
	List<List<Integer>> graph;
	int nodes;
	boolean[] visited;

	public Connected_Component_Graph(int nodes) {
		this.graph = new ArrayList<>();
		this.nodes = nodes;
		this.visited = new boolean[nodes];
		for (int i = 0; i < nodes; i++) {
			graph.add(i, new ArrayList<Integer>());
		}
	}

	public void addEdge(int a, int b) {
		graph.get(a).add(b);
		graph.get(b).add(a);
	}

	public int numberOfConnectedComponent() {
		int numberOfComponents = 0;
		for (int node = 0; node < nodes; node++) {
			if (!visited[node]) {
				dfs(node);
				numberOfComponents++;
			}
		}
		return numberOfComponents;
	}

	private void dfs(int node) {
		Stack<Integer> stack = new Stack<>();
		stack.push(node);
		visited[node] = true;
		while (!stack.isEmpty()) {
			int n = stack.pop();
			List<Integer> neighbours = graph.get(n);
			for (Integer neighbour : neighbours) {
				if (!visited[neighbour]) {
					stack.push(neighbour);
					visited[neighbour] = true;
				}
			}
		}
	}
}
