package com.graph;

import java.util.ArrayList;
import java.util.List;

public class Union_Find_By_Size {

	public static void main(String[] args) {
		DisjointSet_By_Size ds = new DisjointSet_By_Size(7);
		ds.unionBySize(1, 2);
		ds.unionBySize(2, 3);
		ds.unionBySize(4, 5);
		ds.unionBySize(6, 7);
		ds.unionBySize(5, 6);
		// if 3 and 7 same or not
		if (ds.findUPar(3) == ds.findUPar(7)) {
			System.out.println("Same");
		} else {
			System.out.println("Not Same");
		}
		ds.unionBySize(3, 7);
		if (ds.findUPar(3) == ds.findUPar(7)) {
			System.out.println("Same");
		} else {
			System.out.println("Not Same");
		}
	}

}

class DisjointSet_By_Size {

	List<Integer> parent = new ArrayList<>();
	List<Integer> size = new ArrayList<>();

	public DisjointSet_By_Size(int n) {
		for (int i = 0; i <= n; i++) {
			parent.add(i);
			size.add(1);
		}
	}

	public int findUPar(int node) {
		if (node == parent.get(node)) {
			return node;
		}
		int ulp = findUPar(parent.get(node));
		parent.set(node, ulp);
		return parent.get(node);
	}

	public void unionBySize(int u, int v) {
		int ulp_u = findUPar(u);
		int ulp_v = findUPar(v);
		if (ulp_u == ulp_v) {
			return;
		}
		if (size.get(ulp_u) > size.get(ulp_v)) {
			parent.set(ulp_v, ulp_u);
			size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
		} else {
			parent.set(ulp_u, ulp_v);
			size.set(ulp_v, size.get(ulp_u) + size.get(ulp_v));
		}
	}

}
