package com.zhao.leetcode.miInterview;


/**
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 *
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 *
 * 你可以假设数组中不存在重复的元素。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 */

public class Ugxu {

    public static void main(String[] args) {

        System.out.println(search(new int[]{5,1,3},5));

    }


    public static int search(int[] nums, int target) {
        int i = 0 , j = nums.length - 1;

        while (i <= j) {
            int middle = (i + j) / 2;
            if (nums[middle] == target) {
                return middle;
            }
            if (nums[middle] > nums[j]  && nums[middle] > target) {
                while (i <= j) {
                    if(nums[j --] == target) {
                        return j + 1;
                    }
                }
            } else if (nums[j] > target && nums[middle] < target){
                while (i <= j) {
                    if(nums[i ++] == target) {
                        return i - 1;
                    }
                }
            } else if(nums[j] > target) {
                j = middle - 1;
            }
            else if(target > nums[middle]) {
                i = middle + 1 ;
            } else if(target < nums[middle]) {
                j = middle - 1;
            }


            /*if(nums[i] > nums[j]) {
                if(nums[middle] == target) {
                    return middle ;
                }
                if( nums[j] >= target) {
                    i = middle + 1;
                } if(target > nums[middle]) {
                    i = middle + 1 ;
                } else if(target < nums[middle]) {
                    j = middle - 1;
                }
            } else {
                if(target > nums[middle]) {
                    i = middle + 1 ;
                } else if(target < nums[middle]) {
                    j = middle - 1;
                } else {
                    return middle;
                }
            }*/

        }
        return -1;
    }

}
