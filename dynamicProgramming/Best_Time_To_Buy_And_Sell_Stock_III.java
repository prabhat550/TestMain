package com.dp;

public class Best_Time_To_Buy_And_Sell_Stock_III {

	public static void main(String[] args) {

		int[] array = new int[] { 3, 3, 5, 0, 0, 3, 1, 4 };
		int result_Approach1 = maxProfit_Approach1(array);
		System.out.println(result_Approach1);

	}

	// Recursive + Memoization
	// buy = 1 we can buy a stock; buy = 0 we can't buy a stock as we are holding one; k = 2 limited number of transactions	
	public static int maxProfit_Approach1(int[] prices) {
		if (prices.length == 0)
			return 0;
		int[][][] dp = new int[prices.length][2][3];
		return helperMethod_Approach1(prices, 0, 1, dp, 2);
	}
	
	private static int helperMethod_Approach1(int[] prices, int index, int buy, int[][][] dp, int k) {

		if (index == prices.length)
			return 0;
		if (k == 0)
			return 0;
		
		int profit = 0;
		if (buy == 1) {
			profit = Math.max(-prices[index] + helperMethod_Approach1(prices, index + 1, 0, dp, k),
					0 + helperMethod_Approach1(prices, index + 1, 1, dp, k));
		} else {
			profit = Math.max(prices[index] + helperMethod_Approach1(prices, index + 1, 1, dp, k - 1),
					0 + helperMethod_Approach1(prices, index + 1, 0, dp, k));
		}
		return dp[index][buy][k] = profit;
	}

}
