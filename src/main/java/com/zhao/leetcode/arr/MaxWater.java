package com.zhao.leetcode.arr;

/**
 * 容器中转水最多的容器
 */
public class MaxWater {

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1,3,2,5,25,24,5}));
    }

    public static int maxArea(int[] height) {
        int i = 0 , j = height.length - 1;
        int min = height[i] < height[j] ? height[i] : height[j] ,max = (j - i) * min,numMax = 0 , numMin = 0;
        while(i < j) {
            while (i < j) {
                if(height[i] > min && height[j] > min) {
                    break;
                }
                if(height[i] <= min) {
                    i ++;
                }
                if(height[j] <= min) {
                    j --;
                }
                if(i >= j) {
                    return max;
                }
            }
            if(height[i] > height[j]) {
                numMin = (height[i] < height[j] ? height[i] : height[j]) ;
                numMax = (j -- - i) * numMin;
            } else {
                numMin = (height[ i] < height[j] ? height[i] : height[j]);
                numMax = (j - i ++) * numMin;
            }
            if(numMin > min) {
                min = numMin;
            }
            if(max < numMax) {
                max = numMax;
            }
        }
        return max;
    }

}
