package com.zhao.leetcode.bisai.bi202;

/**
 * @program: arithmetic-do-exercise
 * @author: zhaohuan
 * @create: 2020-08-16 10:42
 * @description
 * 地址：https://leetcode-cn.com/contest/weekly-contest-202/problems/three-consecutive-odds/
 * 题目：存在连续三个奇数的数组
 * 描述：给你一个整数数组 arr，请你判断数组中是否存在连续三个元素都是奇数的情况：如果存在，请返回 true ；否则，返回 false 。
 **/
public class ContinuousThreeUneven {

    public boolean threeConsecutiveOdds(int[] arr) {

        if(arr == null || arr.length < 3) {
            return false;
        }

        int result[] = new int[3];
        int mark = 0;
        for(int i = 0 ; i < arr.length ; i ++) {
            if(arr[i] % 2 == 1) {
                result[mark ++] = arr[i];
            }
            if(mark == 3) {
                return true;
            }
            if(arr[i] % 2 == 0) {
                mark = 0 ;
            }
        }
        return false;




    }

}
