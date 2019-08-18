package com.zhao.leetcode.arr;

/**
 * 地址： https://leetcode-cn.com/problems/trapping-rain-water/
 * 接雨水
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *  思路：从第一个位置开始，往右走，高的为止，然后进行下一个
 *  0,1,0,2,1,0,1,3,2,1,2,1    1
 *  5,4,1,2          1
 */
public class ConnRainWater {

    public static void main(String[] args) {

        System.out.println(trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));

    }

    public static int trap(int[] height) {

        int i = 1 , j = height.length - 2,opeI = i - 1 , opeJ = j + 1 , count = 0;
        if( j == 1) {
            int min = Math.min(height[opeI],height[opeJ]) ;
            count += min * 3 ;
            if(count == 0) {
                return 0;
            }
            for(int z = 0 ; z < 3 ; z ++) {
                count -= Math.min(height[z],min);
            }
            return count;

        }
        while (opeI < opeJ) {
            while (i < opeJ && height[i] < height[opeI]) {
                i ++;
            }
            if(height[opeI] <= height[i]) {
                count += (i - opeI - 1) * height[opeI];
                for(int z = opeI + 1 ; z < i && height[opeI] != 0 ; z ++) {
                    count -= Math.min(height[z],height[opeI]);
                }
                opeI = i;
                i ++;
            }

            while (j > opeI && height[j] < height[opeJ]) {
                j -- ;
            }
            if(height[opeJ] <= height[j]) {
                count += (opeJ - j - 1) * height[opeJ];
                for(int z = opeJ - 1 ; z > j && height[opeJ] != 0 ; z --) {
                    count -= Math.min(height[z],height[opeJ]);
                }
                opeJ = j;
                j --;
            }

        }
        return count;

    }


}
