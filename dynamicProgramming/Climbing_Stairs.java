package com.dp;

public class Climbing_Stairs {

    public static void main(String[] args) {
        
        int result_climbStairs = climbStairs(5);
        System.out.println(result_climbStairs);

    }
    
    
 public static int climbStairs(int n) {
        
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        
        for(int i = 2; i <= n; i++){
            dp[i] = dp[i - 1] + dp[i -2];
        }
        
        return dp[n];
    }
}

