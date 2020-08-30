package com.zhao.leetcode.bisai.bi204;

/**
 * @program: arithmetic-do-exercise
 * @author: zhaohuan
 * @create: 2020-08-30 11:25
 * @description
 * 题目：重复至少 K 次且长度为 M 的模式
 * 地址：https://leetcode-cn.com/problems/detect-pattern-of-length-m-repeated-k-or-more-times/
 * 描述：给你一个正整数数组 arr，请你找出一个长度为 m 且在数组中至少重复 k 次的模式。
 *      模式 是由一个或多个值组成的子数组（连续的子序列），连续 重复多次但 不重叠 。 模式由其长度和重复次数定义。
 *      如果数组中存在至少重复 k 次且长度为 m 的模式，则返回 true ，否则返回  false 。
 *
 **/
public class ContinuousRepetition {

    public static void main(String[] args) {
        ContinuousRepetition continuousRepetition = new ContinuousRepetition();
        System.out.println(continuousRepetition.containsPattern(new int[]{1,2,1,2,1,3},2,2));
    }

    public boolean containsPattern(int[] arr, int m, int k) {

        if(arr == null || arr.length < m*k ) {
            return false;
        }
        if(k == 1 && arr.length >= m) {
            return true;
        }
        int repetition = 1;
        boolean falg = true;
        for(int i = 0 ; i < arr.length ; i ++) {

            for(int j = i + 2*m ; j <= arr.length ; j += m) {
                for(int z = 0 ; z < m ; z ++) {
                    if(arr[j - m + z] != arr[j - 2*m + z] ) {
                        if(repetition >= k) {
                            return true;
                        } else {
                            falg = false;
                            repetition = 1;
                            break;
                        }
                    }
                }
                if(falg) {
                    repetition ++ ;
                }
                falg = true;
            }
            if(repetition >= k) {
                return true;
            }
            repetition = 1;
        }
        return false;

    }

}
