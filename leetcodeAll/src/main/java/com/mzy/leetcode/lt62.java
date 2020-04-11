package com.mzy.leetcode;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-03-26 10:21
 **/
public class lt62 {
    public int uniquePaths(int m, int n) {

        if (m <= 0 || n <= 0) return -1;

        int[][] dp = new int[m][n];
        //初始化0行0列
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;

        }
        for (int j = 1; j < n; j++) {
            dp[0][j] = 1;

        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {

                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];

            }

        }

        return dp[m-1][n-1];


    }
}
