package com.dp;

import java.util.HashMap;
import java.util.Map;


// https://leetcode.com/problems/partition-equal-subset-sum/
public class Partition_Equal_Subset_Sum {

    public static void main(String[] args) {

        int[] array = new int[] { 1, 5, 11, 5 };
        boolean result_canPartition = canPartition(array);
        System.out.println(result_canPartition);

    }

    public static boolean canPartition(int[] nums) {

        if (nums == null || nums.length == 0) {
            return false;
        }

        int totalSum = 0;

        for (int a : nums) {
            totalSum += a;
        }

        if (totalSum % 2 != 0) {
            return false;
        }
        
        // return canPartition_BackTracking(nums, 0, 0, totalSum);
        return canPartition_DP(nums, 0, 0, totalSum, new HashMap<String, Boolean>());

    }
    // Recursive
    public static boolean canPartition_BackTracking(int[] nums, int index, int sum, int total) {

        if (sum * 2 == total) {
            return true;
        }
        if (index >= nums.length || sum * 2 > total) {
            return false;
        }
        return canPartition_BackTracking(nums, index + 1, sum + nums[index], total)
                || canPartition_BackTracking(nums, index + 1, sum, total);
    }

    // Recursive + Memoization
    public static boolean canPartition_DP(int[] nums, int index, int sum, int total, Map<String, Boolean> map) {

        String state = index + "" + sum;
        if (map.containsKey(state)) {
            return false;
        }
        if (sum * 2 > total || index >= nums.length) {
            return false;
        }
        if (sum * 2 == total) {
            return true;
        }
        
        boolean foundPartition = canPartition_DP(nums, index + 1, sum + nums[index], total, map)
                || canPartition_DP(nums, index + 1, sum, total, map);
        map.put(state, foundPartition);
        
        return foundPartition;
    }

}
