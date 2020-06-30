package com.zhao.leetcode.arr.hard;

/**
 *  地址：https://leetcode-cn.com/problems/ugly-number/
 *  编写一个程序判断给定的数是否为丑数。
 *  丑数就是只包含质因数 2, 3, 5 的正整数。
 */
public class ChownNum {

    public static void main(String[] args) {
        System.out.println(isUgly(6));
    }

    public static boolean isUgly(int num) {

        int opeNum = 0 ;
        while (num != opeNum) {
            opeNum = num;
            num = num % 2 == 0 ? num / 2 : num;
            num = num % 3 == 0 ? num / 3 : num;
            num = num % 5 == 0 ? num / 5 : num;
        }
        if(num == 1) {
            return true;
        }
        return false;
    }

}
