package com.zhao.leetcode.stock.easy;

/**
 * @program: arithmetic-do-exercise
 * @author: zhaohuan
 * @create: 2022-04-09 10:48
 * @description
 * 地址：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 * 题目：买卖股票的最佳时机
 * 描述：给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 *
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 *
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 **/
public class StockTime {

    public static void main(String[] args) {
        StockTime st = new StockTime();
        System.out.println(st.maxProfit(new int[]{7,1,5,3,6,4}));
    }

    public int maxProfit(int[] prices) {
        int n = prices.length;
        // 动态规划，result记录所有数据中的最大值，min记录上一个中最小的数目
        int result = 0, min = Integer.MIN_VALUE;
        for (int i = 0; i < n; i ++) {
            result = Math.max(result, min + prices[i]);
            min = Math.max(-prices[i], min);
        }
        return result;
    }

}
