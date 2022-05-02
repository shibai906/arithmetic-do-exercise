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

    public static void main(String[] args) {
        findMinArrowShots(new int[][]{{-2147483646,-2147483645},{2147483646,2147483647}});
    }

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
