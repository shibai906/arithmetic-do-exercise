package com.zhao.leetcode.arr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 四数之和，其实在三数之和基础上在进行添加
 */
public class FourNumAdd {

    public static void main(String[] args) {
        fourSum(new int[]{-1,2,2,-5,0,-1,4},3);
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        java.util.Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        if(nums.length < 4) {
            return list;
        }
        int len = nums.length;
        for(int i = 0 ; i < len - 2 ; i ++) {
            if(nums[i] > target && nums[i] > 0) {
                return list;
            }
            if(i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1 , ave = left + 1 , right = len - 1 ;
            while (left < ave && ave < right) {
                while (left < ave && ave < right) {
                    int num = nums[i] + nums[left] + nums[ave] + nums[right];
                    if(num == target) {
                        list.add(Arrays.asList(nums[i],nums[left],nums[ave],nums[right]));
                        // 去重复
                        while ( right > 0 && nums[right] == nums[right - 1]) {
                            right --;
                        }
                        while ( ave < len && nums[ave] == nums[ave + 1]) {
                            ave ++;
                        }
                    }

                    if(num < target) {
                        ave ++ ;
                    } else if(num > target) {
                        right -- ;
                    } else {
                        ave ++ ;
                        right -- ;
                    }
                }
                while ( left < len && nums[left] == nums[left + 1]) {
                    left ++ ;
                }
                left += 1 ;
                ave = left + 1 ;
                right = len - 1;
            }
        }
        return list;
    }

}
