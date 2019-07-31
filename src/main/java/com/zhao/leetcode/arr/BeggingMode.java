package com.zhao.leetcode.arr;


/**
 * 求众数
 *  时间复杂度O(n)
 *  思路，从前往后走
 */
public class BeggingMode {

    public static void main(String[] args) {

    }

    public static int majorityElement(int[] nums) {

        int i = 1 , j = nums.length - 1;
        int account = 1 ;
        int mode = nums[0];
        while (i < j) {
            if(i < j && nums[i] == mode) {
                account ++ ;
            } else {
                account -- ;
                if(account < 0) {
                    account = 1 ;
                    mode = nums[i];
                }
            }
            if(++ i < j && nums[j] == mode ) {
                account ++;
            } else {
                account -- ;
                if(account < 0) {
                    account = 1 ;
                    mode = nums[j];
                }
            }
            j -- ;
        }
        return mode;
    }

}
