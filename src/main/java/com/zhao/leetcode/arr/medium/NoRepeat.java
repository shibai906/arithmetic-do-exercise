package com.zhao.leetcode.arr.medium;

import java.util.Arrays;

/**
 * @program: arithmetic-do-exercise
 * @author: zhaohuan
 * @create: 2022-04-30 01:54
 * @description
 * 地址：https://leetcode-cn.com/problems/non-overlapping-intervals/
 * 题目：无重叠区间
 * 描述：给定一个区间的集合 intervals ，其中 intervals[i] = [starti, endi] 。返回 需要移除区间的最小数量，使剩余区间互不重叠 。
 *
 **/
public class NoRepeat {

    // 贪心算法，右边需要排序
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (int[] a1, int[] a2) ->{
            return a1[1] - a2[1];
        });
        int right = intervals[0][1], result = 0;
        for (int i = 1; i < intervals.length; i ++) {
            if (right > intervals[i][0]) {
                result ++;
            } else {
                right = intervals[i][1];
            }
        }
        return result;
    }

}
