package com.tree;

import java.util.HashMap;
import java.util.Map;

public class Path_Sum_III {

	public static void main(String[] args) {

		TreeNode node = new TreeNode(10);

		node.left = new TreeNode(5);
		node.right = new TreeNode(-3);

		node.left.left = new TreeNode(3);
		node.left.right = new TreeNode(2);
		node.right.right = new TreeNode(11);

		node.left.left.left = new TreeNode(3);
		node.left.left.right = new TreeNode(-2);
		node.left.right.right = new TreeNode(1);
		node.right.right.right = new TreeNode(1);

		int result_Approach1 = pathSum_Approach1(node, 8);
		System.out.println(result_Approach1);

		int result_Approach2 = pathSum_Approach2(node, 8);
		System.out.println(result_Approach2);

	}

	private static int total_Approach1 = 0;
	private static int total_Approach2 = 0;
	
	// Brute Force
	public static int pathSum_Approach1(TreeNode root, int targetSum) {
		if (root == null)
			return 0;
		findPathSum_Approach1(root, 0, targetSum);
		pathSum_Approach1(root.left, targetSum);
		pathSum_Approach1(root.right, targetSum);
		return total_Approach1;
	}

	private static void findPathSum_Approach1(TreeNode root, int currentSum, int targetSum) {
		if (root == null)
			return;
		currentSum += root.value;
		if (currentSum == targetSum)
			total_Approach1++;
		findPathSum_Approach1(root.left, currentSum, targetSum);
		findPathSum_Approach1(root.right, currentSum, targetSum);
	}

	// Optimized Approach	
	public static int pathSum_Approach2(TreeNode root, int targetSum) {
		
		if(root == null)
			return 0;
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, 1);
		findPathSum_Approach2(root, 0, targetSum, map);
		return total_Approach2;
	}

	private static void findPathSum_Approach2(TreeNode root, int currentSum, int targetSum, Map<Integer, Integer> map) {
		if(root == null)
			return;
		currentSum += root.value;
		if(map.containsKey(currentSum - targetSum)) {
			total_Approach2++;
		}
		map.put(currentSum, map.getOrDefault(currentSum, 0) + 1);
		findPathSum_Approach2(root.left, currentSum, targetSum, map);
		findPathSum_Approach2(root.right, currentSum, targetSum, map);
		map.put(currentSum, map.get(currentSum) - 1);
		return;
	}

}
