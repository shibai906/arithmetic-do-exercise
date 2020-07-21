package com.zhao.leetcode.bisai.bi197;

/**
 * @program: arithmetic-do-exercise
 * @author: zhaohuan
 * @create: 2020-07-12 10:32
 * @description
 * 题目： 好数对的数目
 * 习题：给你一个整数数组 nums 。
 *  如果一组数字 (i,j) 满足 nums[i] == nums[j] 且 i < j ，就可以认为这是一组 好数对 。
 *  返回好数对的数目。
 *  链接：https://leetcode-cn.com/contest/weekly-contest-197/problems/number-of-good-pairs/
 **/
public class GoodNum {

    public int numIdenticalPairs(int[] nums) {

        int result = 0 ;
        for(int i = 0 ; i < nums.length - 1 ; i ++) {
            for(int j = i + 1 ; j < nums.length ; j ++) {
                if(nums[i] == nums[j]) {
                    result ++ ;
                }
            }
        }
        return result;

    }

}
