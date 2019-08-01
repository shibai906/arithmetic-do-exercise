package com.zhao.leetcode.integer;

/**
 * 计数质数
 *  统计所有小于非负整数n的质数的数量
 */
public class PrimeInteger {

    public static void main(String[] args) {
        System.out.println(countPrimes(10));
    }

    public static int countPrimes(int n) {
        int count = 0 ;
        for(int i = 2 ; i <= n ; i ++) {
            int num = 0 ;

            for(int j = 2 ; j <= (int)Math.sqrt(i) ; j ++ ) {
                if(i % j == 0) {
                    num = 1 ;
                    break;
                }
            }
            if(num == 0) {
                count ++;
            }
        }
        return count;
    }

}
