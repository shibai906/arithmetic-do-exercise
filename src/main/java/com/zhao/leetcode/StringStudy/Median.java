package com.zhao.leetcode.StringStudy;

/**
 * 合并子串
 */
public class Median {
    public static void main(String[] args) {

        int[] arr = new int[] {1,2,3};
        System.out.println(findMedianSortedArrays(new int[]{1,2},new int[]{3,4}));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int[] nums3 = new int[nums1.length + nums2.length];
        int i = 0,j = 0,z = 0;
        while(i < nums1.length && j < nums2.length) {
            if(nums1[i] > nums2[j]) {
                nums3[z++] = nums2[j ++];
            }
            else {
                nums3[z++] = nums1[i ++];
            }
        }
        System.arraycopy(nums1,i,nums3,z,nums1.length-i  );
        System.arraycopy(nums2,j,nums3,z,nums2.length-j );
        if(nums3.length == 0) {
            return 0;
        }
        if(nums3.length % 2 == 0 ) {
            int ave = (nums3.length - 1) / 2;
            return (double) (nums3[ave] + nums3[ave + 1]) / 2;
        }

        return (double) nums3[(nums3.length - 1) / 2];


    }
}
