package com.zhao.leetcode;

import java.util.Arrays;

/**
 *  合并两个有序数组
 */
public class MergeNum {

    public static void main(String[] args) {
        int[] num1 = {1,2,3,4,5,0};
        int[] num2 = {6};
        heMerge(num1,5,num2,1);
        System.out.println(Arrays.toString(num1));
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        int index = m + n - 1;
        int i = m - 1 , j = n - 1;
        while (i >= 0 || j >= 0) {
            if(i >= 0 && j >= 0 && nums1[i] > nums2[j]) {
                nums1[index --] = nums1[i --];
            } else if(i >= 0 && j >= 0 && nums1[i] < nums2[j]) {
                nums1[index --] = nums2[j --];
            } else if(i >= 0 && j >= 0 ) {
                nums1[index --] = nums1[i --];
                nums1[index --] = nums2[j --];
            } else if(i >= 0) {
                nums1[index --] = nums1[i --];
            } else if(j >= 0) {
                nums1[index --] = nums2[j --];
            }
        }

    }

    public static void heMerge(int[] nums1, int m , int[] nums2 , int n) {

        int index = m + n - 1 ;
        m -= 1;
        n -= 1;
        for(; index >= 0 ; index --) {
            if(m < 0) {
                nums1[index] = nums2[n --];
                continue;
            }
            if(n < 0) {
                nums1[index] = nums1[m --];
                continue;
            }
            if(nums1[m] > nums2[n]) {
                nums1[index] = nums1[m --];
            } else {
                nums1[index] = nums2[n --];
            }
        }


    }

}
