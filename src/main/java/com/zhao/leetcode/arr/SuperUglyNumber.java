package com.zhao.leetcode.arr;

import javax.management.ObjectName;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * 地址： https://leetcode-cn.com/problems/super-ugly-number/
 *   313.超级丑数
 *   编写一段程序来查找第 n 个超级丑数。
 *   超级丑数是指其所有质因数都是长度为 k 的质数列表 primes 中的正整数。
 *
 * 示例:
 *  输入: n = 12, primes = [2,7,13,19]
 *  输出: 32
 *  解释: 给定长度为 4 的质数列表 primes = [2,7,13,19]，前 12 个超级丑数序列为：[1,2,4,7,8,13,14,16,19,26,28,32] 。
 *
 */
public class SuperUglyNumber {

    public static void main(String[] args) {

        System.out.println(nthSuperUglyNumber(12,new int[]{2,7,13,19}));

    }

    public static int nthSuperUglyNumber(int n, int[] primes) {

        if(n == 0 || primes == null || primes.length == 0) {
            return 0;
        }
        int[] dp = new int[n];
        dp[0] = 1;
        int[] priDp = new int[primes.length] ;

        for(int i = 1 ; i < n ; i ++) {
            int min = dp[priDp[0]] * primes[0] , weizhi = 0 ;
            for(int j = 0 ; j < primes.length ; j ++) {
                if(min > dp[priDp[j]] * primes[j]) {
                    min = dp[priDp[j]] * primes[j];
                    weizhi = j;
                }
            }
            priDp[weizhi] ++;
            while(min <= dp[i - 1]) {
                min = dp[priDp[0]] * primes[0];
                weizhi = 0;
                for(int j = 0 ; j < primes.length ; j ++) {
                    if(min > dp[priDp[j]] * primes[j]) {
                        min = dp[priDp[j]] * primes[j];
                        weizhi = j;
                    }
                }
                priDp[weizhi] ++;
            }
            dp[i] = min;
        }
        System.out.println(Arrays.toString(dp));
        return dp[n - 1];
    }

}
