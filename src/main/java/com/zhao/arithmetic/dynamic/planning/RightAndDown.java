package com.zhao.arithmetic.dynamic.planning;

/**
 * @program: arithmetic-do-exercise
 * @description 走不同路径，给一个m*n的网格，只能往右或者往下移动一步
 * @author: zhaohuan
 * @create: 2020-03-25 18:34
 * 做法： 动态规划
 **/
public class RightAndDown {

    public static void main(String[] args) {
        System.out.println(fun(1,1));
    }

    public static int fun(int m, int n) {
        if(m <= 0 || n <= 0 ) {
            return 0;
        }
        int[][] arr = new int[m][n];
        for(int i = 0 ; i < m ; i ++) {
            for(int j = 0 ; i < n ; i ++ ) {
                if(i == 0 || j == 0) {
                    arr[i][j] = 1;
                } else {
                    arr[i][j] = arr[i - 1][j] + arr[i][j - 1];
                }
            }
        }
        return arr[m - 1][n - 1];

    }

}
