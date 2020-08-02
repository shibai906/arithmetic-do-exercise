package com.zhao.leetcode.bisai.bi200;

/**
 * @program: arithmetic-do-exercise
 * @author: zhaohuan
 * @create: 2020-08-02 10:38
 * @description
 * 地址：https://leetcode-cn.com/contest/weekly-contest-200/problems/count-good-triplets/
 * 题目：统计好三元组
 * 描述：给你一个整数数组 arr ，以及 a、b 、c 三个整数。请你统计其中好三元组的数量。
 *  如果三元组 (arr[i], arr[j], arr[k]) 满足下列全部条件，则认为它是一个 好三元组 。
 *  0 <= i < j < k < arr.length
 *  |arr[i] - arr[j]| <= a
 *  |arr[j] - arr[k]| <= b
 *  |arr[i] - arr[k]| <= c
 *  其中 |x| 表示 x 的绝对值。
 *
 * 返回 好三元组的数量 。
 **/
public class StatisticsTriad {

    public int countGoodTriplets(int[] arr, int a, int b, int c) {

        int result = 0 ;
        for(int i = 0 ; i < arr.length - 2 ; i ++) {
            for(int j = i + 1 ; j < arr.length - 1 ; j ++) {
                for(int k = j + 1 ; k < arr.length ; k ++) {
                    if(Math.abs(arr[i] - arr[j]) <= a) {
                        if(Math.abs(arr[j] - arr[k]) <= b) {
                            if(Math.abs(arr[i] - arr[k]) <= c) {
                                result ++;
                            }
                        }
                    }
                }
            }
        }
        return result;
    }

}
