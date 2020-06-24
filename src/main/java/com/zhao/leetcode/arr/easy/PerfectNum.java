package com.zhao.leetcode.arr.easy;

/**
 * 地址： https://leetcode-cn.com/problems/perfect-number/
 *  完美数
 *  对于一个 正整数，如果它和除了它自身以外的所有正因子之和相等，我们称它为“完美数”。
 *  给定一个 整数 n， 如果他是完美数，返回 True，否则返回 False
 *
 */
public class PerfectNum {

    public static void main(String[] args) {

        System.out.println(checkPerfectNumber(6));

    }

    public static boolean checkPerfectNumber(int num) {

        if(num == 1) {
            return false;
        }
        int sum = 1; // 正整数一定会有一个1，同时不用考虑自身，所以单独处理
        int i = 2;
        double sqrt = Math.sqrt(num);
        for(;i < sqrt;i++) {
            if(num % i == 0) {
                sum += i;
                sum += num / i;
            }
        }
        // 此处单独处理的原因在于只需要加1次i值，如果在循环中会加2次
        if(i * i == num) {
            sum += i;
        }
        return sum == num;

    }


}
