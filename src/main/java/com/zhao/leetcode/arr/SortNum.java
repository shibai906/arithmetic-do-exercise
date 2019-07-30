package com.zhao.leetcode.arr;

import java.util.*;

/**
 *  在排序数组中查找元素的第一个和最后一个位置
 */
public class SortNum {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(searchRange1(new int[]{1},1)));
    }

    public static int[] searchRange(int[] nums, int target) {
        List<Integer> list = new ArrayList<>();
        int[] arr = {-1,-1};
        for(int i = 0 ; i < nums.length ; i ++) {
            if(nums[i] == target) {
                if(arr[0] == -1) {
                    arr[0] = list.size();
                    arr[1] = list.size();
                } else {
                    arr[1] = list.size();
                }
            }
            list.add(nums[i]);
        }
        return arr;
    }

    // 折半查找数组中元素
    public static int[] searchRange1(int[] nums, int target) {
        int[] arr = {-1,-1};
        int len = nums.length;
        if(len < 1) {
            return arr;
        }
        int i = 0 ;
        int j = len - 1;
        int ave = ( j + i ) / 2;
        while( nums[ave] != target &&  i < j) {
            if(nums[ave] > target) {
                j = ave - 1;
                ave = (i + j) / 2;
            }
            if(nums[ave] < target) {
                i = ave + 1;
                ave = (i + j) / 2;
            }
        }
        if(nums[ave] != target) {
            return arr;
        }
        for(i = ave  ; i >= 0 ; i --) {
            if(nums[i] != target) {
                arr[0] = i + 1;
                break;
            }
        }
        if(arr[0] == -1) {
            arr[0] = 0;
        }
        for(i = ave ; i < len ; i ++) {
            if(nums[i] != target) {
                arr[1] = i - 1;
                break;
            }
        }
        if(arr[1] == -1) {
            arr[1] = len - 1;
        }
        return arr;
    }



}
