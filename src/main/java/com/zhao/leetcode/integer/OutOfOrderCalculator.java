package com.zhao.leetcode.integer;

/**
 * 地址：https://leetcode-cn.com/problems/broken-calculator/
 * 坏了计算器
 *  在显示着数字的坏计算器上，我们可以执行以下两种操作：
 *
 *     双倍（Double）：将显示屏上的数字乘 2；
 *     递减（Decrement）：将显示屏上的数字减 1 。
 *
 * 最初，计算器显示数字 X。
 *
 * 返回显示数字 Y 所需的最小操作数。
 *
 */
public class OutOfOrderCalculator {

    public static void main(String[] args) {

    }

    public static int brokenCalc(int X, int Y) {

        int ans = 0 ;
        while (Y > X) {
            ans ++ ;
            if(Y % 2 == 1) {
                Y = (Y + 1) / 2;
                ans += 2;
            } else {
                Y = Y / 2;
                ans ++;
            }
        }
        return ans + X - Y;

    }

}
