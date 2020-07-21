package com.zhao.leetcode.bisai.bi198;

/**
 * @program: arithmetic-do-exercise
 * @author: zhaohuan
 * @create: 2020-07-19 10:33
 * @description
 *
 * 题目：换酒问题
 *
 * 描述：小区便利店正在促销，用 numExchange 个空酒瓶可以兑换一瓶新酒。你购入了 numBottles 瓶酒。
 *  如果喝掉了酒瓶中的酒，那么酒瓶就会变成空的。
 *  请你计算 最多 能喝到多少瓶酒。
 *
 * 地址：https://leetcode-cn.com/contest/weekly-contest-198/problems/water-bottles/
 *
 **/
public class ExchangeWine {


    public static void main(String[] args) {
        ExchangeWine ew = new ExchangeWine();
        System.out.println(ew.numWaterBottles(9,3));
    }

    public int numWaterBottles(int numBottles, int numExchange) {

        int result = numBottles;

        int exchange = numBottles / numExchange;
        result += exchange;
        int remaining = exchange + numBottles % numExchange;

        while(remaining >= numExchange) {
            exchange = remaining / numExchange;
            result += exchange;
            remaining = exchange + remaining % numExchange;
        }
        return result;

    }

}
