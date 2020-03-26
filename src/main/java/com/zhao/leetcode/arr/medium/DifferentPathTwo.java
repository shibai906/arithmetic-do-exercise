package com.zhao.leetcode.arr.medium;

/**
 * @program: arithmetic-do-exercise
 * @description
 *  地址： https://leetcode-cn.com/problems/unique-paths-ii/
 *  题目： 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 *  机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 *  现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 *
 * @author: zhaohuan
 * @create: 2020-03-25 18:52
 **/
public class DifferentPathTwo {

    public static void main(String[] args) {
        leetcodeFun(new int[][]{{0,1,1,1},{0,1,0,0},{0,0,0,0}});
    }
    public static int fund(int[][] arr) {

        if(arr == null) {
            return 0;
        }
        int m = arr.length;
        int n = arr[0].length;
        if(arr[0][0] == 1) {
            return 0;
        }
        if(arr[m-1][n-1] == 1 ) {
            return 0;
        }

        arr[0][0] = 1;
        for(int i = 1 ; i < m ; i ++) {
            arr[i][0] = (arr[i - 1][0] == 1 && arr[i][0] == 0) ? 1 : 0;
        }
        for(int i = 1 ; i < n ; i ++) {
            arr[0][i] = (arr[0][i - 1] == 1 && arr[0][i] == 0) ? 1 : 0;
        }

        /**
         * 后续需要分析这里为什么错误
         */
//        for(int i = 0 ; i < m ; i ++) {
//            if(arr[i][0] == 0) {
//                arr[i][0] = 1;
//            }else {
//                for(; i < m ; i ++) {
//                    arr[i][0] = 0;
//                }
//            }
//        }
//        for(int i = 1 ; i < n ; i ++) {
//            if(arr[0][i] == 0) {
//                arr[0][i] = 1;
//            }else {
//                for(; i < n ; i ++) {
//                    arr[0][1] = 0;
//                }
//            }
//        }

        for(int i = 1 ; i < m ; i ++) {
            for(int j = 1 ; j < n ; j ++) {
                if(arr[i][j] == 1) {
                    arr[i][j] = 0 ;
                }
                else {
                    arr[i][j] = arr[i - 1][j] + arr[i][j-1];
                }
            }
        }
        return arr[m - 1][n - 1];
    }

    public static int leetcodeFun(int[][] obstacleGrid) {
        int R = obstacleGrid.length;
        int C = obstacleGrid[0].length;

        // If the starting cell has an obstacle, then simply return as there would be
        // no paths to the destination.
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }

        // Number of ways of reaching the starting cell = 1.
        obstacleGrid[0][0] = 1;

        // Filling the values for the first column
        for (int i = 1; i < R; i++) {
            obstacleGrid[i][0] = (obstacleGrid[i][0] == 0 && obstacleGrid[i - 1][0] == 1) ? 1 : 0;
        }

        // Filling the values for the first row
        for (int i = 1; i < C; i++) {
            obstacleGrid[0][i] = (obstacleGrid[0][i] == 0 && obstacleGrid[0][i - 1] == 1) ? 1 : 0;
        }

        // Starting from cell(1,1) fill up the values
        // No. of ways of reaching cell[i][j] = cell[i - 1][j] + cell[i][j - 1]
        // i.e. From above and left.
        for (int i = 1; i < R; i++) {
            for (int j = 1; j < C; j++) {
                if (obstacleGrid[i][j] == 0) {
                    obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
                } else {
                    obstacleGrid[i][j] = 0;
                }
            }
        }

        // Return value stored in rightmost bottommost cell. That is the destination.
        return obstacleGrid[R - 1][C - 1];

    }

}
