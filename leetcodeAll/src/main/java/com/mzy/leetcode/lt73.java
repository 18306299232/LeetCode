package com.mzy.leetcode;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-04-09 14:16
 **/
public class lt73 {
    public void setZeroes(int[][] matrix) {
        boolean hasZeroX = false;
        boolean hasZeroY = false;

        int n = matrix.length;
        int m = matrix[0].length;

        for (int i = 0; i < n; i++) {
            if (matrix[i][0] == 0) {
                hasZeroX = true;
                break;
            }
        }
        for (int i = 0; i < m; i++) {
            if (matrix[0][i] == 0) {
                hasZeroY = true;
                break;
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }

            }
        }
        for (int i = 1; i < n; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 1; j < m; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int i = 1; i < m; i++) {
            if (matrix[0][i] == 0) {
                for (int j = 1; j < n; j++) {
                    matrix[j][i] = 0;
                }
            }
        }
        if (hasZeroX) {
            for (int i = 0; i < n; i++) {
                matrix[i][0] = 0;
            }
        }
        if (hasZeroY) {
            for (int i = 0; i < m; i++) {
                matrix[0][i] = 0;
            }
        }


    }
}
