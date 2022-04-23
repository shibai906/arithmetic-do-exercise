package com.zhao.leetcode.arr.hard;

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

    /**
     * 接雨水问题：
     *  1、使用动态规划，从左边看的最大值，从右边看的最大值
     * @param height
     * @return
     */
    public static int trap(int[] height) {
        if (height == null || height.length < 3) {
            return 0;
        }
        int n = height.length;
        int[] leftSight = new int[n];
        int[] rightSight = new int[n];
        // 左边视角最大值
        int max = 0, i = 0;
        for (; i < n; i ++) {
            max = Math.max(max, height[i]);
            leftSight[i] = max;
        }
        max = 0;
        i --;
        // 右边视角最大值
        for (; i >= 0; i --) {
            max = Math.max(max, height[i]);
            rightSight[i] = max;
        }
        int result = 0;
        i ++;
        for (; i < n; i ++) {
            result += Math.min(leftSight[i], rightSight[i]) - height[i];
        }
        return result;
    }

    /**
     * 可以使用双指针，最左最右找出低洼
     * @param height
     * @return
     */
    public int trapTwoPoint(int[] height) {
        if (height == null || height.length < 3) {
            return 0;
        }
        int n = height.length, left = 0, right = n - 1, leftMax = height[left], rightMax = height[right], result = 0;
        while(left < right) {
            if (height[left] < height[right]) {
                if (leftMax < height[left]) {
                    leftMax = height[left];
                } else {
                    result += leftMax - height[left];
                }
                left ++;
            } else {
                if (rightMax < height[right]) {
                    rightMax = height[right];
                } else {
                    result += rightMax - height[right];
                }
                right --;
            }
        }
        return result;
    }


}
