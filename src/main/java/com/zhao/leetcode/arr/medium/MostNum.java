package com.zhao.leetcode.arr.medium;

/**
 * @program: arithmetic-do-exercise
 * @author: zhaohuan
 * @create: 2022-03-13 12:00
 * @description
 * 题目：给一个正整数二维数组，求上下左右相等最多的数。
 * 示例： 1  2  3  3
 *       2  3  3  3     最多的数是5
 * 类型：头条面试题
 **/
public class MostNum {

    public static void main(String[] args) {

        MostNum num = new MostNum();
        System.out.println(num.fun(new int[][]{{1,2,3,3},{2,3,3,3}}));

    }

    public int fun(int arr[][]) {
        if (arr == null || arr.length == 0 || arr[0].length == 0) {
            return 0;
        }
        int max = 0;
        for (int i = 0; i < arr.length; i ++) {
            for (int j = 0; j < arr.length; j ++) {
                max = Math.max(dfs(i, j, arr, arr[i][j]), max);
            }
        }
        return max;
    }

    private int dfs(int i, int j, int[][] arr, int target) {
        int num = 0;
        if (arr[i][j] < 0) {
            return num;
        }
        if (target == arr[i][j]) {
            arr[i][j] = -1;
            if (i > 0) {
                num += dfs(i - 1, j, arr, target);
            }
            if (j > 0) {
                num += dfs(i, j - 1, arr, target);
            }
            if (i < arr.length - 1) {
                num += dfs(i + 1, j, arr, target);
            }
            if (j < arr[0].length - 1) {
                num += dfs(i, j + 1, arr, target);
            }

            num += 1;
        }

        return num;
    }

}
