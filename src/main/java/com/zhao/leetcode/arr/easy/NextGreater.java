package com.zhao.leetcode.arr.easy;

/**
 * 地址： https://leetcode-cn.com/problems/next-greater-element-i/
 * 题目： 下一个更大元素 I
 * 描述： 给定两个没有重复元素的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。找到 nums1 中每个元素在 nums2 中的下一个比其大的值。
 *       nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。如果不存在，对应位置输出-1。
 *
 */
public class NextGreater {

    public static void main(String[] args) {
        nextGreaterElement(new int[]{4,1,2},new int[]{1,3,4,2});
    }

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        if(nums1 == null || nums2 == null) {
            return null;
        }
        int[] result = new int[nums1.length];
        for(int i = 0 ; i < result.length ; i ++) {
            result[i] = -1;
            for(int j = 0 ; j < nums2.length ; j ++) {
                if(nums1[i] == nums2[j]) {
                    for(; j < nums2.length; j ++) {
                        if(nums1[i] < nums2[j]) {
                            result[i] = nums2[j];
                            break;
                        }
                    }
                }
            }
        }
        return result;
    }

}
