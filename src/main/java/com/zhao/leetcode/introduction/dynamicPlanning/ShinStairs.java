package com.zhao.leetcode.introduction.dynamicPlanning;

/**
 * 爬楼梯
 *  假设你正在爬楼梯，需要n阶你才能到达楼顶
 */
public class ShinStairs {

    public static void main(String[] args) {
<<<<<<< HEAD
        System.out.println(climbStairs(4));
=======

        int num = 2 ;
        int nums = 4;

        num =+ nums;

        System.out.println(num);

 //       System.out.println(climbStairs(5));
>>>>>>> ca28d5efb39616088366a55f88e3416607ad58db
    }

    public static int climbStairs(int n) {
        if(n < 3) {
            return n;
        }
        int firt = 1 ,second = 2 , last = 0;
        for(int i = 3 ; i <= n ; i ++) {
            second = firt + second ;
            firt = second - firt;
        }
        return second;
    }

}
