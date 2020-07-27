package com.zhao.leetcode.bisai.twobi31;

/**
 * @program: arithmetic-do-exercise
 * @author: zhaohuan
 * @create: 2020-07-25 22:33
 * @description
 * 地址：https://leetcode-cn.com/contest/biweekly-contest-31/problems/count-odd-numbers-in-an-interval-range/
 * 题目：在区间范围内统计奇数数目
 * 描述：给你两个非负整数 low 和 high 。请你返回 low 和 high 之间（包括二者）奇数的数目。
 **/
public class OddNumber {

    public static void main(String[] args) {
        OddNumber on = new OddNumber();
        on.countOdds(3,7);
    }

    public int countOdds(int low, int high) {

        int result = ( high - low) / 2 ;
        if((high - low) % 2 == 1) {
            result ++ ;
        }
        if((high - low) % 2 == 0 && low % 2 == 1) {
            result ++;
        }
        return result;

    }

}
