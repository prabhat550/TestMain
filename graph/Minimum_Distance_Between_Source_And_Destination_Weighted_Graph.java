package com.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Minimum_Distance_Between_Source_And_Destination_Weighted_Graph {

	public static void main(String[] args) {

		Dijkstra_Algorithm dijkstra_Algorithm = new Dijkstra_Algorithm(5);
		dijkstra_Algorithm.addEdge(0, 1, 1);
		dijkstra_Algorithm.addEdge(0, 2, 7);
		dijkstra_Algorithm.addEdge(1, 2, 5);
		dijkstra_Algorithm.addEdge(1, 4, 4);
		dijkstra_Algorithm.addEdge(4, 3, 2);
		dijkstra_Algorithm.addEdge(2, 3, 6);
		int result = dijkstra_Algorithm.getMinimumDistance(0, 3);
		System.out.println(result);

	}

}

// Will work for both directed and undirected graph
class Dijkstra_Algorithm {

	List<List<Edge>> graph;
	int[] distance;
	boolean[] visited;

	public Dijkstra_Algorithm(int nodes) {
		this.graph = new ArrayList<>();
		this.distance = new int[nodes];
		this.visited = new boolean[nodes];
		for (int i = 0; i < nodes; i++) {
			graph.add(i, new ArrayList<Edge>());
			distance[i] = Integer.MAX_VALUE;
		}
	}

	public void addEdge(int source, int destination, int distance) {
		this.graph.get(source).add(new Edge(destination, distance));
	}

	public int getMinimumDistance(int source, int destination) {
		if (source == destination)
			return 0;
		PriorityQueue<Edge> minHeap = new PriorityQueue<Edge>((e1, e2) -> e1.distance - e2.distance);
		distance[source] = 0;
		minHeap.add(new Edge(0, 0));
		while (!minHeap.isEmpty()) {
			int curr_node = minHeap.poll().targetNode;
			if(visited[curr_node]) 
				continue;
			List<Edge> neighbourList = graph.get(curr_node);
			for (Edge neighbour : neighbourList) {
				int dist_next_node = neighbour.distance;
				int next_node = neighbour.targetNode;
				if (!visited[next_node] && (distance[curr_node] + dist_next_node < distance[next_node])) {
					distance[next_node] = distance[curr_node] + dist_next_node;
					neighbour.distance = distance[curr_node] + dist_next_node;
					minHeap.add(neighbour);
				}
			}
		}
		return distance[destination];
	}
}

class Edge {

	int targetNode;
	int distance;

	public Edge(int destination, int distance) {
		super();
		this.targetNode = destination;
		this.distance = distance;
	}

}
