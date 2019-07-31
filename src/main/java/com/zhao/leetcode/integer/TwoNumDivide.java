package com.zhao.leetcode.integer;

/**
 * 两数相除
 */
public class TwoNumDivide {

    public static void main(String[] args) {
        System.out.println(divide(2147483647,-1118209564));
    }

    public static int divide(int dividend, int divisor) {
        boolean falg = true;
        if(divisor < 0) {
            if(divisor == -Integer.MAX_VALUE - 1) {
                if(dividend == divisor) {
                    return 1;
                }
                return 0;
            }
            divisor = -divisor;
            falg = false;
        }
        int shrift = 0 ;
        if(dividend < 0) {
            if(dividend == -Integer.MAX_VALUE - 1) {
                shrift = 1;
                dividend = Integer.MAX_VALUE;
            } else {
                dividend = - dividend  ;
            }
            if(falg) {
                falg = false;
            } else {
                falg = true;
            }
        }
        if(divisor > dividend) {
            return 0;
        }
        int num = 0 ;
        int count = divisor;
        int buffer = 1 ;
        while( dividend >= divisor) {
            int addCount = count + count ;
            if(addCount < 0 || addCount > dividend) {
                count = divisor;
                buffer = 1 ;
            } else {
                count = addCount;
                buffer += buffer ;
            }
            num += buffer;
            dividend -= count;
        }
        if(dividend + shrift == divisor) {
            if(num == Integer.MAX_VALUE) {
                if(!falg) {
                    return -Integer.MAX_VALUE - 1;
                }
            } else {
                num ++ ;
            }
        }
        if(!falg) {
            num = - num;
        }
        return num;


    }

}
