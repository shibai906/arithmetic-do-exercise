package com.zhao.leetcode.arr;

/**
 * 旋转数组
 *  给定一个数组，将数组中的元素向右移动k个位置，其中k是非负数。
 */
public class RodateArray {

    public static void main(String[] args) {
        rotate(new int[]{1,2,3,4,5,6,7},9);
    }

    public static void rotate(int[] nums, int k) {
        int len = nums.length;
        while (len < k) {
            k -= len;
        }
        int[] arr = new int[k];

        for(int i = 0 ; i < k ; i ++) {
            arr[i] = nums[i] ;
            nums[i] = nums[len - k + i ] ;
        }

        for(;  len > 2*k  ; len --) {
            nums[len - 1] = nums[len - k - 1] ;
        }
        k = 2 * k < len ? k : len - k ;
        for(; k > 0 ; k --) {
            nums[--len] = arr[k-1];
        }

    }

}
