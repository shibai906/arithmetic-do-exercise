package com.zhao.leetcode.integer;

import java.util.Map;

/**
 * 地址： https://leetcode-cn.com/problems/number-of-digit-one/
 * 题目： 数字1的个数
 * 给定一个整数 n，计算所有小于等于 n 的非负整数中数字 1 出现的个数。
 */
public class FigureOneNumber {

    public static void main(String[] args) {
        System.out.println(countDigitOne(13));
    }

    public static int countDigitOne(int n) {
        int num = 0 , ceng = 0;

        while (Math.pow(ceng,10) > n) {

            int yushu = (int) (n % Math.pow(ceng,10));

            if(yushu > 1) {
                 if(ceng > 1) {
                     num += n % Math.pow(ceng - 1 , 10) ;
                 }
            }

            ceng ++;

        }

        return 0;

    }

}
