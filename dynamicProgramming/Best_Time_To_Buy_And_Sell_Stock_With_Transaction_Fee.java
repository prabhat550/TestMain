package com.dp;

public class Best_Time_To_Buy_And_Sell_Stock_With_Transaction_Fee {

	public static void main(String[] args) {

		int[] array = new int[] { 1, 3, 2, 8, 4, 9 };
		int result_Approach1 = maxProfit_Approach1(array, 2);
		System.out.println(result_Approach1);

		int result_Tabulation = result_Approach2(array, 2);
		System.out.println(result_Tabulation);

	}

	// Recursive + Memoization
	// buy = 1 we can buy a stock; buy = 0 we can't buy a stock as we are holding
	// one; transaction fee when we sell the stock
	public static int maxProfit_Approach1(int[] prices, int fee) {
		Integer[][] dp = new Integer[prices.length][2];
		return helperMethod_Approach1(prices, 0, 1, fee, dp);
	}

	private static int helperMethod_Approach1(int[] prices, int index, int buy, int fee, Integer[][] dp) {

		if (index == prices.length)
			return 0;
		if (dp[index][buy] != null)
			return dp[index][buy];
		int profit = 0;
		
		if (buy == 1) {
			profit = Math.max(-prices[index] + helperMethod_Approach1(prices, index + 1, 0, fee, dp),
					0 + helperMethod_Approach1(prices, index + 1, 1, fee, dp));
		} else {
			profit = Math.max(prices[index] - fee + helperMethod_Approach1(prices, index + 1, 1, fee, dp),
					0 + helperMethod_Approach1(prices, index + 1, 0, fee, dp));
		}
		return dp[index][buy] = profit;
	}

	public static int result_Approach2(int[] prices, int fee) {

		int n = prices.length;
		if (n <= 1)
			return 0;

		int[][] dp = new int[n][2];

		dp[0][0] = 0;
		dp[0][1] = -prices[0] - fee;

		for (int i = 1; i < n; i++) {
			dp[i][0] = Math.max(dp[i - 1][1] + prices[i], dp[i - 1][0]);
			dp[i][1] = Math.max(dp[i - 1][0] - prices[i] - fee, dp[i - 1][1]);
		}

		return dp[n - 1][0];
	}

}
