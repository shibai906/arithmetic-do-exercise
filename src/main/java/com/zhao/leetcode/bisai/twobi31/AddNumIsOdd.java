package com.zhao.leetcode.bisai.twobi31;

/**
 * @program: arithmetic-do-exercise
 * @author: zhaohuan
 * @create: 2020-07-25 22:48
 * @description
 * 地址：https://leetcode-cn.com/contest/biweekly-contest-31/problems/number-of-sub-arrays-with-odd-sum/
 * 题目：和为奇数的子数组数目
 * 描述：给你一个整数数组 arr 。请你返回和为 奇数 的子数组数目。
 *      由于答案可能会很大，请你将结果对 10^9 + 7 取余后返回。
 **/
// TODO: 2020/7/26 不懂这个题，还得感觉做 
public class AddNumIsOdd {

    private int adda = 0;
    public static void main(String[] args) {
        AddNumIsOdd ano = new AddNumIsOdd();
        System.out.println(ano.numOfSubarrays(new int[]{100,100,99,99}));
    }


    public int numOfSubarrays(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        digui(arr, 0, 0);
        return adda;
    }

    private void digui(int[] arr, int start, int and) {

        for (int i = start; i < arr.length; i ++) {
            if ((and + arr[i]) % 2 == 1) {
                adda ++;
            }
            digui(arr, i + 1, and + arr[i]);
            if (arr[i] % 2 == 1) {
                adda ++;
            }
            digui(arr, i + 1, 0);
        }

    }


}
