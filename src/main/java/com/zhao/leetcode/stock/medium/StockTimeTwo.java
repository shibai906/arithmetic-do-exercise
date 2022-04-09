package com.zhao.leetcode.stock.medium;

/**
 * @program: arithmetic-do-exercise
 * @author: zhaohuan
 * @create: 2022-04-09 15:22
 * @description
 **/
public class StockTimeTwo {

    public int maxProfit(int[] prices) {

        int result = 0, jilu = Integer.MIN_VALUE;

        for (int price : prices) {
            result = Math.max(result, jilu + price);
            // 加上连续大于0值的和
            result = Math.max(jilu, result - price);
        }
        return result;


    }

}
