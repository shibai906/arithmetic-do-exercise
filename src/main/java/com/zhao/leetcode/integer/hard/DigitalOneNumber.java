package com.zhao.leetcode.integer.hard;

/**
 * @program: arithmetic-do-exercise
 * @author: zhaohuan
 * @create: 2020-11-01 15:51
 * @description
 * 地址：https://leetcode-cn.com/problems/number-of-digit-one/
 * 题目：数字 1 的个数
 * 描述：给定一个整数 n，计算所有小于等于 n 的非负整数中数字 1 出现的个数。
 **/
public class DigitalOneNumber {

    public static void main(String[] args) {
        DigitalOneNumber on = new DigitalOneNumber();
        System.out.println(on.countDigitOne(110));
    }

    public int countDigitOne(int n) {
        if(n <= 0) {
            return 0;
        }
        int num = 1, result = 0, remainder = 0, wei = 1, chushu = 0;
        remainder = n % 10;
        if(remainder > 0) {
            result += 1;
            chushu = remainder;
        }
        n = n / 10;
        while(n > 0) {
            remainder = n % 10;
            if(remainder == 1) {
                result += (chushu + 1);
            } else if (remainder > 1) {
                result += Math.pow(10,wei);
            }
            chushu = (int) (Math.pow(10,wei - 1) * n + chushu);
            n = n /10;
            result += remainder * num;
            num = (int) (wei * Math.pow(10,wei));
            wei ++;
        }
        return result;
    }


}
