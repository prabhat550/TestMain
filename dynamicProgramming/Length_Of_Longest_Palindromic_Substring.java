package com.dp;

public class Length_Of_Longest_Palindromic_Substring {

    public static void main(String[] args) {

        int result = lengthOfPalindromicSubstring("abccbc");
        System.out.println(result);

    }

    private static int lengthOfPalindromicSubstring(String s) {

        boolean[][] dp = new boolean[s.length()][s.length()];
        int result = 0;

        for (int g = 0; g < dp.length; g++) {
            for (int i = 0, j = g; j < dp.length; i++, j++) {
                if (i == j) {
                    dp[i][j] = true;
                } else if (g == 1 && s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = true;
                } else if (dp[i + 1][j - 1] == true && s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = true;
                }
                if (dp[i][j] == true) {
                    result = g + 1;
                }
            }
        }
        return result;
    }

}
