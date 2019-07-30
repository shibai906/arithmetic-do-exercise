package com.zhao.leetcode.arr;

/**
 * 最接近的三数之和
 */
public class ThreeNumJieJing {

    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[]{6,-18,-20,-7,-15,9,18,10,1,-20,-17,-19,-3,-5,-19,10,6,-11,1,-17,-15,6,17,-18,-3,16,19,-20,-3,-17,-15,-3,12,1,-9,4,1,12,-2,14,4,-4,19,-20,6,0,-19,18,14,1,-15,-5,14,12,-4,0,-10,6,6,-6,20,-8,-6,5,0,3,10,7,-2,17,20,12,19,-13,-1,10,-1,14,0,7,-3,10,14,14,11,0,-4,-15,-8,3,2,-5,9,10,16,-4,-3,-9,-8,-14,10,6,2,-12,-7,-16,-6,10
        },-52));
    }

    public static int threeSumClosest(int[] nums, int target) {
        java.util.Arrays.sort(nums);
        int result = nums[0] + nums[1] + nums[2];
        int len = nums.length;
        for(int i = 0 ; i < len ; i ++) {
            if(nums[i] >= target && result > target){
                return result;
            }
            int left = i + 1 , right = len - 1 ;
            while (left < right) {
                int num = nums[i] + nums[left] + nums[right] ;
                if(Math.abs(num - target) < Math.abs(result - target)) {
                    result = num;
                }
                if(num > target) {
                    right -- ;
                } else if (num < target) {
                    left ++;
                } else {
                    return result;
                }
            }
        }
        return result;
    }

}
