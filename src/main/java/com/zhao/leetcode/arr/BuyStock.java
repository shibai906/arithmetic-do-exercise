package com.zhao.leetcode.arr;

public class BuyStock {

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{2,4,1}));
    }

    public static int maxProfit(int[] prices) {
        if(prices == null || prices.length < 2) {
            return 0;
        }

        int min = prices[0] , max = 0 , cha = 0;
        for(int i = 1 ; i < prices.length ; i ++) {
            if(prices[i] > min && max < prices[i]) {
                max = prices[i];
            }
            if(min > prices[i]) {
                cha = cha > max - min ? cha : max - min ;
                max = 0 ;
                min = prices[i];
            }
        }

        return cha > max - min ? cha : max - min;

    }

}
