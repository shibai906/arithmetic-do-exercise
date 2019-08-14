package com.zhao.leetcode.integer;

/**
 * 地址： https://leetcode-cn.com/problems/sqrtx/
 *  题目：x的平方根
 *  实现 int sqrt(int x) 函数。
 *  计算并返回 x 的平方根，其中 x 是非负整数。
 *  由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去
 */
public class XSquareRoot {

    public static void main(String[] args) {
        System.out.println(Math.sqrt(2147395599));
        System.out.println(mySqrt(2147483647));
    }

    public static int mySqrt(int x) {

        if(x == 0) {
            return 0;
        }
        int num = 1 , result = 1;
        while ((long)result * result < x ) {
            if((long)(result + num) * (result + num) > x) {
                num = 1;
                result += 1;
            } else {
                result += num;
                num *= 2;
            }
        }
        return (long)result * result > x ? result - 1 : result ;


    }

}
