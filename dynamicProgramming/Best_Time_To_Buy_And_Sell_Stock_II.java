package com.dp;

public class Best_Time_To_Buy_And_Sell_Stock_II {

	public static void main(String[] args) {

		int[] array = new int[] { 7, 1, 5, 3, 6, 4 };
		int result_Approach1 = maxProfit_Approach1(array);
		System.out.println(result_Approach1);

	}

	public static int maxProfit_Approach1(int[] prices) {
		if (prices.length == 0)
			return 0;
		Integer[][] dp = new Integer[prices.length][2];
		return helperMethod_Approach1(prices, 0, 1, dp);

	}

	// Recursive + Memoization
	// buy = 1 we can buy a stock; buy = 0 we can't buy a stock as we are holding one
	private static int helperMethod_Approach1(int[] prices, int index, int buy, Integer[][] dp) {

		if (index == prices.length)
			return 0;
		if (dp[index][buy] != null)
			return dp[index][buy];
		int profit = 0;
		if (buy == 1) {
			profit = Math.max(-prices[index] + helperMethod_Approach1(prices, index + 1, 0, dp),
					0 + helperMethod_Approach1(prices, index + 1, 1, dp));
		} else {
			profit = Math.max(prices[index] + helperMethod_Approach1(prices, index + 1, 1, dp),
					0 + helperMethod_Approach1(prices, index + 1, 0, dp));
		}
		return dp[index][buy] = profit;
	}

}
