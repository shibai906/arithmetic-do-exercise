package com.zhao.leetcode.动态规划.medium;

/**
 * @program: arithmetic-do-exercise
 * @author: zhaohuan
 * @create: 2022-05-21 16:46
 * @description
 * 地址：https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
 * 题目：买卖股票的最佳时机含手续费
 * 描述：给定一个整数数组 prices，其中 prices[i]表示第 i 天的股票价格 ；整数 fee 代表了交易股票的手续费用。
 *  你可以无限次地完成交易，但是你每笔交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。
 * 返回获得利润的最大值。
 * 注意：这里的一笔交易指买入持有并卖出股票的整个过程，每笔交易你只需要为支付一次手续费。
 *
 *
 **/
public class 买卖股票的最佳时机含手续费 {

    public int maxProfit(int[] prices, int fee) {
        // 需要记录当前的最大值及其记录值的最大值
        int result = 0, jilu = Integer.MIN_VALUE;
        for (int price : prices) {
            result = Math.max(result, jilu + price);
            jilu = Math.max(jilu, result - price - fee);
        }
        return result;
    }

}
