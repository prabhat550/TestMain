package com.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Time_Needed_To_Inform_All_Employees {

	public static void main(String[] args) {

		int[] manager = new int[] { 2, 2, -1, 2, 2, 2 };
		int[] informTime = new int[] { 0, 0, 1, 0, 0, 0 };
		int n = 6;
		int headId = 2;
		int result = numOfMinutes(n, headId, manager, informTime);
		System.out.println(result);

	}

	private static int time_needed = 0;

	public static int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
		Map<Integer, List<Integer>> graph = new HashMap<>();
		for (int i = 0; i < n; i++) {
			if (manager[i] == -1)
				continue;
			if (!graph.containsKey(manager[i])) {
				List<Integer> list = new ArrayList<Integer>();
				list.add(i);
				graph.put(manager[i], list);
			} else {
				List<Integer> list = graph.get(manager[i]);
				list.add(i);
				graph.put(manager[i], list);
			}
		}
		calculateTime(headID, graph, informTime, 0);
		return time_needed;
	}

	private static void calculateTime(int headID, Map<Integer, List<Integer>> graph, int[] informTime, int t) {
		if (informTime[headID] == 0)
			return;
		t = t + informTime[headID];
		List<Integer> temp = graph.get(headID);
		for (int i = 0; i < temp.size(); i++) {
			calculateTime(temp.get(i), graph, informTime, t);
			time_needed = Math.max(time_needed, t);
		}
	}

}
