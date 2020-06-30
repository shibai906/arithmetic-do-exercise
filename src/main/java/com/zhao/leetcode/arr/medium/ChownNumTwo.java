package com.zhao.leetcode.arr.medium;

/**
 *  地址： https://leetcode-cn.com/problems/ugly-number-ii/
 *  264. 丑数II
 *  编写一个程序，找出第 n 个丑数。
 *  丑数就是只包含质因数 2, 3, 5 的正整数。
 */
public class ChownNumTwo {

    public static void main(String[] args) {
        System.out.println(2);
    }

    public static int nthUglyNumber(int n) {

        if(n < 4) {
            return n;
        }
        int[] dp = new int[n] ;
        dp[0] = 1 ;
        int i2 = 0 , i3 = 0 , i5 = 0 ;
        for(int i = 1 ; i < n ; i ++) {
            int min = Math.min(dp[i2] * 2 , Math.min(dp[i3] * 3 , dp[i5] * 5));
            if(min == dp[i2] * 2) {
                i2 ++ ;
            }
            if(min == dp[i3] * 3) {
                i3 ++ ;
            }
            if(min == dp[i5] * 5) {
                i5 ++ ;
            }
            dp[i] = min;
        }
        return dp[n - 1];

    }

}
