package com.zhao.leetcode.bisai.twobi32;

/**
 * @program: arithmetic-do-exercise
 * @author: zhaohuan
 * @create: 2020-08-08 22:35
 * @description
 * 地址：https://leetcode-cn.com/contest/biweekly-contest-32/problems/kth-missing-positive-number/
 * 题目：第 k 个缺失的正整数
 * 描述：给你一个 严格升序排列 的正整数数组 arr 和一个整数 k 。
 *      请你找到这个数组里第 k 个缺失的正整数。
 **/
public class DeficiencyNum {

    public static void main(String[] args) {
        DeficiencyNum dn = new DeficiencyNum();
        dn.findKthPositive(new int[]{2,3,4,7,11} , 5);
    }

    public int findKthPositive(int[] arr, int k) {
        int pre = 0 ;
        for(int num : arr) {

            if(num - pre > k) {
                return pre + k;
            }
            k -= num - pre - 1;
            pre = num;
        }
        return arr[arr.length - 1] + k;

    }

}
