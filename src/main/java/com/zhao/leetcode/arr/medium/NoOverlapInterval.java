package com.zhao.leetcode.arr.medium;

import java.util.Arrays;

/**
 * @program: arithmetic-do-exercise
 * @author: zhaohuan
 * @create: 2022-04-30 10:14
 * @description
 * 地址：https://leetcode-cn.com/problems/non-overlapping-intervals/
 * 题目：无重叠区间
 * 描述：给定一个区间的集合 intervals ，其中 intervals[i] = [starti, endi] 。返回 需要移除区间的最小数量，使剩余区间互不重叠 。
 *
 **/
public class NoOverlapInterval {

    /**
     * 贪心算法
     * @param points
     * @return
     */
    public static int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (int[] a1, int[] a2) ->{
            long result = (long)a1[1] - (long)a2[1];
            return result > 0 ? 1 : -1;
        });
        int result = 0, right = points[0][1];
        for (int i = 1; i < points.length; i ++) {
            if (right < points[i][0]) {
                result ++;
                right = points[i][1];
            }
        }
        return result;
    }

}
