package com.mzy.leetcode;

import java.util.Map;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-03-26 10:54
 **/
public class lt64 {
    public int minPathSum(int[][] grid) {

        if (grid == null || grid.length <= 0) return -1;

        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        //初始化0行0列
        dp[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }

        for (int i = 1; i < n; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }

        return dp[m - 1][n - 1];


    }

    //使用空间复杂为on的
    public int minPathSum2(int[][] grid) {

        if (grid == null || grid.length <= 0) return -1;

        int m = grid.length;
        int n = grid[0].length;
        int[] dp = new int[n];

        //初始化dp
        dp[0] = grid[0][0];
        for (int i = 1; i < n; i++) {
            dp[i] = dp[i - 1] + grid[0][i];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    dp[j] += grid[i][0];
                } else {
                    dp[j] = grid[i][j] + Math.min(dp[j - 1], dp[j]);
                }
            }
        }

        return dp[n - 1];


    }

}