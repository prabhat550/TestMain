package com.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class Cheapest_Flights_Within_K_Stops {

	public static void main(String[] args) {

		int[][] flight_Approach1 = new int[][] { { 0, 1, 100 }, { 1, 2, 100 }, { 2, 0, 100 }, { 1, 3, 600 }, { 2, 3, 200 } };
		int result_Approach1 = findCheapestPrice_Approach1(4, flight_Approach1, 0, 3, 1);
		System.out.println(result_Approach1);
		
		int[][] flight_Approach2 = new int[][] { { 1, 2, 10 }, { 2, 0, 7 }, { 1, 3, 8 }, { 4, 0, 10 }, { 3, 4, 2 }, { 4, 2, 10 },
				{ 0, 3, 3 }, { 3, 1, 6 }, { 2, 4, 5 } };
		int result_Approach2 = findCheapestPrice_Approach2(5, flight_Approach2, 0, 4, 1);
		// int result_Approach2 = findCheapestPrice_Approach2(4, flight_Approach1, 0, 3, 1);
		System.out.println(result_Approach2);

	}

	public static int findCheapestPrice_Approach1(int n, int[][] flights, int src, int dst, int k) {
		Map<Integer, List<int[]>> graph = new HashMap<>();
		for (int i = 0; i < flights.length; i++) {
			graph.putIfAbsent(flights[i][0], new ArrayList<int[]>());
			graph.get(flights[i][0]).add(new int[] { flights[i][1], flights[i][2] });
		}
		// Queue stores -> src, cost, stops
		PriorityQueue<int[]> minHeap = new PriorityQueue<int[]>((o1, o2) -> o1[1] - o2[1]);
		minHeap.offer(new int[] { src, 0, k });
		while (!minHeap.isEmpty()) {
			int[] node = minHeap.poll();
			int curr_val = node[0];
			int cost = node[1];
			int stops = node[2];
			if (curr_val == dst)
				return cost;
			if (stops >= 0) {
				if (!graph.containsKey(curr_val))
					continue;
				for (int[] neighbour : graph.get(curr_val)) {
					minHeap.add(new int[] { neighbour[0], cost + neighbour[1], stops - 1 });
				}
			}
		}
		return -1;
	}

	public static int findCheapestPrice_Approach2(int n, int[][] flights, int src, int dst, int k) {
		Map<Integer, List<int[]>> adj = new HashMap<>();
		for (int[] i : flights)
			adj.computeIfAbsent(i[0], value -> new ArrayList<>()).add(new int[] { i[1], i[2] });

		int[] dist = new int[n];
		Arrays.fill(dist, Integer.MAX_VALUE);

		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { src, 0 });
		int stops = 0;

		while (stops <= k && !q.isEmpty()) {
			int sz = q.size();
			// Iterate on current level.
			while (sz-- > 0) {
				int[] temp = q.poll();
				int node = temp[0];
				int distance = temp[1];

				if (!adj.containsKey(node))
					continue;
				// Loop over neighbors of popped node.
				for (int[] e : adj.get(node)) {
					int neighbour = e[0];
					int price = e[1];
					if (price + distance >= dist[neighbour])
						continue;
					dist[neighbour] = price + distance;
					q.offer(new int[] { neighbour, dist[neighbour] });
				}
			}
			stops++;
		}
		return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
	}

}
