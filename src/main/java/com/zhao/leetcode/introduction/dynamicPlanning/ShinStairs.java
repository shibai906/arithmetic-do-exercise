package com.zhao.leetcode.introduction.dynamicPlanning;

/**
 * 爬楼梯
 *  假设你正在爬楼梯，需要n阶你才能到达楼顶
 */
public class ShinStairs {

    public static void main(String[] args) {
        System.out.println(climbStairs(5));
    }

    public static int climbStairs(int n) {
        if(n < 2) {
            return n;
        }
        int[] arr = new int[n + 1] ;
        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 2;
        for(int i = 3 ; i <= n ; i ++) {
//            arr[i ] = arr[i - 1] + 2*arr[i - 2] - i > 4 ;
        }
        return arr[n];


    }

}
