package com.zhao.leetcode.arr.medium;

import java.util.Arrays;

/**
 * @program: arithmetic-do-exercise
 * @author: zhaohuan
 * @create: 2022-05-22 14:51
 * @description
 * 地址：https://leetcode.cn/problems/minimum-lines-to-represent-a-line-chart/
 * 题目： 表示一个折线图的最少线段数
 * 描述： 给你一个二维整数数组 stockPrices ，其中 stockPrices[i] = [dayi, pricei] 表示股票在 dayi 的价格为 pricei 。折线图 是一个二维平面上的若干个点组成的图，横坐标表示日期，纵坐标表示价格，折线图由相邻的点连接而成。比方说下图是一个例子：
 *
 **/
public class MinNum {

    public static void main(String[] args) {

    }

    public int minimumLines(int[][] stockPrices) {
        Arrays.sort(stockPrices, (n1, n2) -> n1[0] - n2[0]);
        int result = 1;
        for (int i = 2; i <stockPrices.length; i ++) {
            result += ((stockPrices[i][0] - stockPrices[i - 1][0]) * (stockPrices[i - 1][1] - stockPrices[i - 2][1]) == (stockPrices[i][1] - stockPrices[i - 1][1]) * (stockPrices[i - 1][0] - stockPrices[i - 2][0])) ? 1 : 0;
        }
        return result;
    }

}
