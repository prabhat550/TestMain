package com.dp;

public class Count_All_Palindromic_Substrings {

    public static void main(String[] args) {

        int result = countAllPalindromicSubstring("abccbc");
        System.out.println(result);

    }

    // 2-D Matrix Diagnol Traversal
    public static int countAllPalindromicSubstring(String s) {

        boolean[][] dp = new boolean[s.length()][s.length()];
        int count = 0;

        for (int g = 0; g < s.length(); g++) {
            for (int i = 0, j = g; j < dp.length; i++, j++) {
                if (g == 0) {
                    dp[i][j] = true;
                } else if (g == 1) {
                    if (s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = false;
                    }
                } else {
                    if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1] == true) {
                        dp[i][j] = true;
                    }
                }
                if (dp[i][j] == true)
                    count++;
            }
        }
        return count;
    }

}
