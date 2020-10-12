package com.zhao.leetcode.arr.easy;

/**
 * @program: arithmetic-do-exercise
 * @author: zhaohuan
 * @create: 2020-09-12 12:59
 * @description
 * 地址：https://leetcode-cn.com/problems/count-primes/
 * 题目：计数质数
 * 描述：统计所有小于非负整数 n 的质数的数量。
 **/
public class CountPrimeNumbers {

    public static void main(String[] args) {
        CountPrimeNumbers cpn = new CountPrimeNumbers();
        System.out.println(cpn.countPrimes(499979));
    }

    public int countPrimes(int n) {

        if(n < 2) {
            return 0;
        }
        int result = 0;
        int arr[] = new int[n];
        for(int i = 2 ; i < n ; i ++) {
            if(arr[i - 1] == 0) {
                result ++;
            }
            for(int j = i * 2 ; j < n ; j += i) {
                arr[j - 1] = 1;
            }
        }
        return result;

    }


}
