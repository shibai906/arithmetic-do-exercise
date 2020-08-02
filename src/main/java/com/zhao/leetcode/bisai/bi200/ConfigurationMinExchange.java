package com.zhao.leetcode.bisai.bi200;

/**
 * @program: arithmetic-do-exercise
 * @author: zhaohuan
 * @create: 2020-08-02 11:40
 * @description
 * 地址：https://leetcode-cn.com/contest/weekly-contest-200/problems/minimum-swaps-to-arrange-a-binary-grid/
 * 题目：排布二进制网格的最少交换次数
 * 描述：给你一个 n x n 的二进制网格 grid，每一次操作中，你可以选择网格的 相邻两行 进行交换。
 *      一个符合要求的网格需要满足主对角线以上的格子全部都是 0 。
 *      请你返回使网格满足要求的最少操作次数，如果无法使网格符合要求，请你返回 -1 。
 *      主对角线指的是从 (1, 1) 到 (n, n) 的这些格子。
 **/
public class ConfigurationMinExchange {

    public static void main(String[] args) {
        ConfigurationMinExchange ce = new ConfigurationMinExchange();
        System.out.println(ce.minSwaps(new int[][] {{0,0,1},{1,1,0},{1,0,0}}));
    }

    public int minSwaps(int[][] grid) {

        if(grid == null) {
            return 0 ;
        }
        int result = 0;
        for(int i = grid.length - 1 ; i > 0 ; i -- ) {
            int num = jisuan(i , grid);
            if (num < 0) {
                return - 1;
            }
            result += num;
        }
        return result;

    }

    private int jisuan(int i, int[][] grid) {
        int arr[] = new int[grid.length] ;
        int len = 0;
        for(int j = 0 ; j < grid.length ; j ++) {
            if(grid[j][i] == 0) {
                arr[len ++] = j ;
            }
        }
        if(len < i) {
            return -1 ;
        }
        int result = 0;
        for(int j = 0 ; j < i ; j ++) {
            result += (arr[j] - j) ;
        }
        return result;
    }

}
