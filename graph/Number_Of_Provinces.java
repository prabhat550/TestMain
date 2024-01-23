package com.graph;

public class Number_Of_Provinces {

	public static void main(String[] args) {

		int[][] isConnected = new int[][] { { 1, 1, 0 }, { 1, 1, 0 }, { 0, 0, 1 } };
		int result = findCircleNum(isConnected);
		System.out.println(result);

	}

	public static int findCircleNum(int[][] isConnected) {
		int result = 0;
		for (int i = 0; i < isConnected.length; i++) {
			if (isConnected[i][i] == 1) {
				result++;
				dfs(isConnected, i);
			}
		}
		return result;
	}

	private static void dfs(int[][] isConnected, int i) {
		int[] edges = isConnected[i];
		if (edges[i] == 1) {
			edges[i] = 0;
			for (int j = 0; j < edges.length; j++) {
				if (edges[j] == 1) {
					edges[j] = 0;
					dfs(isConnected, j);
				}
			}
		}
	}

}
