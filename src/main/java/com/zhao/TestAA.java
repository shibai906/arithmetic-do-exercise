package com.zhao;

/**
 * @program: arithmetic-do-exercise
 * @author: zhaohuan
 * @create: 2021-09-08 23:46
 * @description
 **/
public class TestAA {
    public String s = "a";

    public static void main(String[] args) {
        int[] dp = new int[]{1,1,1};

        int a = 0, b = 0;
        for (int num : dp) {
            b = ~a & (b ^ num);
            a = ~b & (a ^ num);
        }
        System.out.println(~1);
        System.out.println(b);


    }


}
