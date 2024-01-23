package com.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Graph_Topological_Sort {

	public static void main(String[] args) {

		Topological_Sort topologicalSort = new Topological_Sort(6);
		topologicalSort.addEdge(0, 1);
		topologicalSort.addEdge(0, 2);
		topologicalSort.addEdge(1, 3);
		topologicalSort.addEdge(1, 4);
		topologicalSort.addEdge(2, 4);
		topologicalSort.addEdge(3, 5);
		topologicalSort.addEdge(4, 5);
		List<Integer> result = topologicalSort.topologicalSort();
		System.out.println(result);

	}

}

class Topological_Sort {

	private List<List<Integer>> graph;
	private Map<Integer, Integer> incomingDegree;
	private Queue<Integer> sourceQueue;
	private List<Integer> result;
	int nodes;

	Topological_Sort(int nodes) {
		this.nodes = nodes;
		this.graph = new ArrayList<>();
		this.incomingDegree = new HashMap<>();
		this.sourceQueue = new LinkedList<>();
		this.result = new ArrayList<>();
		for (int i = 0; i < nodes; i++) {
			graph.add(i, new ArrayList<>());
			incomingDegree.put(i, 0);
		}
	}

	public void addEdge(int source, int destination) {
		graph.get(source).add(destination);
		incomingDegree.put(destination, incomingDegree.get(destination) + 1);
	}

	public List<Integer> topologicalSort() {
		for (Map.Entry<Integer, Integer> entry : incomingDegree.entrySet()) {
			if (entry.getValue() == 0) {
				sourceQueue.offer(entry.getKey());
			}
		}
		while (!sourceQueue.isEmpty()) {
			int val = sourceQueue.poll();
			result.add(val);
			List<Integer> neighbourList = graph.get(val);
			for (int neighbour : neighbourList) {
				incomingDegree.put(neighbour, incomingDegree.get(neighbour) - 1);
				if (incomingDegree.get(neighbour) == 0) {
					sourceQueue.add(neighbour);
				}
			}
		}
		if (result.size() != nodes) {
			System.out.println("This is a cyclic graph");
			return new ArrayList<Integer>();
		}
		return result;
	}

}
