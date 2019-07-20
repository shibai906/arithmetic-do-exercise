package com.zhao.leetcode;

import java.util.concurrent.ThreadPoolExecutor;

public class HuiWenNum {
    public static void main(String[] args) {
        System.out.println(isPalindrome(123));
    }

    public static boolean isPalindrome(int x) {
        if(x < 0) {
            return false;
        }
        int z = 0 ,opeX = x;
        while (opeX != 0) {
            z = z * 10 + opeX % 10;
            opeX = opeX / 10;
        }
        if(z == x) {
            return true;
        }
        return false;


    }

}
