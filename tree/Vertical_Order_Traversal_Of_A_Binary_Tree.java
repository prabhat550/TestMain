package com.tree;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class Vertical_Order_Traversal_Of_A_Binary_Tree {

	public static void main(String[] args) {

		TreeNode node = new TreeNode(1);

		node.left = new TreeNode(2);
		node.right = new TreeNode(3);

		node.left.left = new TreeNode(4);
		node.left.right = new TreeNode(5);
		node.right.left = new TreeNode(6);
		node.right.right = new TreeNode(7);

		List<List<Integer>> result = verticalOrderTraversal(node);
		System.out.println(result);

	}

	public static List<List<Integer>> verticalOrderTraversal(TreeNode node) {

		List<List<Integer>> result = new ArrayList<>();
		if (node == null)
			return result;
		Queue<Point> queue = new LinkedList<>();
		queue.offer(new Point(node, 0, 0));
		Comparator<Point> comparator = (a, b) -> {
			if (a.y == b.y) {
				return a.node.value - b.node.value;
			} else {
				return a.y - b.y;
			}
		};
		Map<Integer, PriorityQueue<Point>> map = new HashMap<>();
		int minhl = Integer.MAX_VALUE, maxhl = Integer.MIN_VALUE;
		while (!queue.isEmpty()) {
			int n = queue.size();
			for (int i = 0; i < n; i++) {
				Point point = queue.remove();
				maxhl = Math.max(maxhl, point.x);
				minhl = Math.min(minhl, point.x);
				map.putIfAbsent(point.x, new PriorityQueue<Point>(comparator));
				map.get(point.x).add(point);
				if (point.node.left != null)
					queue.offer(new Point(point.node.left, point.x - 1, point.y + 1));
				if (point.node.right != null)
					queue.offer(new Point(point.node.right, point.x + 1, point.y + 1));
			}
		}
		for (int i = minhl; i <= maxhl; i++) {
			PriorityQueue<Point> pq = map.get(i);
			List<Integer> list = new ArrayList<>();
			while (!pq.isEmpty()) {
				list.add(pq.poll().node.value);
			}
			result.add(list);
		}
		return result;
	}
}

class Point {

	TreeNode node;
	int x;
	int y;

	Point(TreeNode node, int x, int y) {
		this.node = node;
		this.x = x;
		this.y = y;
	}

}




