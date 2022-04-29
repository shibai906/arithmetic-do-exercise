package com.zhao;

import java.util.Arrays;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: arithmetic-do-exercise
 * @author: zhaohuan
 * @create: 2021-09-08 23:46
 * @description
 **/
public class TestAA {
    public String s = "a";
    public static void main(String[] args) throws InterruptedException {
        eraseOverlapIntervals(new int[][]{{1,2},{2,3},{3,4},{1,3}});
    }

    public static int eraseOverlapIntervals(int[][] intervals) {
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
