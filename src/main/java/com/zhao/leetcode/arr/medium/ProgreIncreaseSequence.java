package com.zhao.leetcode.arr.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *  地址： https://leetcode-cn.com/problems/increasing-subsequences/
 * 递增子序列
 *  给定一个整型数组, 你的任务是找到所有该数组的递增子序列，递增子序列的长度至少是2。
 *  输入: [4, 6, 7, 7]
 *  输出: [[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7]]
 *
 * 说明：
 *  给定数组的长度不会超过15。
 *  数组中的整数范围是 [-100,100]。
 *  给定数组中可能包含重复数字，相等的数字应该被视为递增的一种情况。
 */
public class ProgreIncreaseSequence {

    public static void main(String[] args) {

    }

    public static List<List<Integer>> findSubsequences(int[] nums) {
        int len = nums.length;
        List<List<Integer>> lists = new ArrayList<>();
        int[] weizhi = new int[len];
        int geshu = 0, num = 0 ;
        for(int i = 0; i < len ; i ++) {
            List<Integer> list = new LinkedList<>();
            geshu += i + 1;
            num = 1 ;
            list.add(nums[i]);
            while (geshu <= len) {
                if(num == 1) {
                    if(i == 0 || nums[i] != nums[i - 1]) {
                        lists.add(list);
                    }
                    num = 1 ;
                    weizhi[i] = 1;
                } else {
                    if(num != geshu) {
                        for(int j = i + 1 ; j < geshu  ; j ++) {
                            weizhi[i + j] = 1;
                            num ++ ;
                            list.add(nums[i+j]);
                        }
                        lists.add(list);
                    } else {
                        boolean flag = true ;
                        for(int j = i + 1; j < len ; j ++) {
                            if(nums[len -j] == 0) {
                                flag = false;
                                int hou = len - j ;
                                for(;j < len ; j ++) {
                                    if(nums[len - j] == 1) {
                                        int qian = len - j ;
                                        if(nums[hou] == nums[qian]) {
      //                                      nums[nums]
                                        }
                                    }
                                }
                                nums[len - j - 1] = 0;
                                list.remove(list.size() - j);
                                list.add(len - j - 1,nums[len - j - 1]);
                            }
                        }
                        if(flag) {
                            geshu ++ ;
                        }
                    }

                }

            }
        }
        return null;

    }


}
