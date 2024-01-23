package com.tree;

import java.util.Deque;
import java.util.LinkedList;

public class Same_Tree {

	public static void main(String[] args) {

		TreeNode p = new TreeNode(1);
		p.left = new TreeNode(2);
		p.right = new TreeNode(3);

		TreeNode q = new TreeNode(1);
		q.left = new TreeNode(2);
		q.right = new TreeNode(3);

		boolean result_Iterative = isSameTree_Iterative(p, q);
		System.out.println(result_Iterative);

		boolean result_Recursive = isSameTree_Recursive(p, q);
		System.out.println(result_Recursive);

	}

	public static boolean isSameTree_Iterative(TreeNode p, TreeNode q) {
		if (p == null || q == null)
			return false;
		Deque<TreeNode> deque = new LinkedList<>();
		deque.add(p);
		deque.add(q);
		while (!deque.isEmpty()) {
			p = deque.poll();
			q = deque.poll();
			if (p == null && q == null)
				continue;
			if (p == null || q == null)
				return false;
			if (p.value != q.value)
				return false;
			deque.add(p.left);
			deque.add(q.left);
			deque.add(p.right);
			deque.add(q.right);
		}
		return true;
	}

	public static boolean isSameTree_Recursive(TreeNode p, TreeNode q) {
		if (p == null && q == null)
			return true;
		if (p == null || q == null)
			return false;
		if (p.value != q.value)
			return false;
		return isSameTree_Recursive(p.left, q.left) && isSameTree_Recursive(p.right, q.right);
	}
}
