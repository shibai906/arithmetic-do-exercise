package com.zhao.leetcode.arr.hard;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * 给定一个未排序的整数数组，找出最长连续序列的长度。
 * 要求算法的时间复杂度为 O(n)。
 *
 * 输入: [100, 4, 200, 1, 3, 2]
 * 输出: 4
 * 解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。
 * @program: arithmetic-do-exercise
 * @description
 * @author: zhaohuan
 * @create: 2020-01-27 16:29
 **/
public class MaxContinueOrder {

    public static void main(String[] args) {
        MaxContinueOrder order = new MaxContinueOrder();
        order.longestConsecutive(new int[]{100,4,200,1,3,2});
    }

    public int longestConsecutive(int[] nums) {

        if(nums == null || nums.length == 0) {
            return 0;
        }
        Set<Integer> set = new TreeSet<>();
        for(int num : nums) {
            set.add(num);
        }
        Iterator<Integer> iterator = set.iterator();
        int max = 1 ,prev = iterator.next(),num = 1;
        while (iterator.hasNext()) {
            int next = iterator.next();
            if(next - prev == 1) {
                num ++ ;
            } else {
                max = max >= num ? max : num;
                num = 1 ;
            }

            prev = next;
        }
        return max >= num ? max : num;
    }

}
