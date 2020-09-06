package com.zhao.leetcode.bisai.bi205;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: arithmetic-do-exercise
 * @author: zhaohuan
 * @create: 2020-09-06 11:12
 * @description
 * 地址：https://leetcode-cn.com/problems/number-of-ways-where-square-of-number-is-equal-to-product-of-two-numbers/
 * 题目：数的平方等于两数乘积的方法数
 * 描述：给你两个整数数组 nums1 和 nums2 ，请你返回根据以下规则形成的三元组的数目（类型 1 和类型 2 ）：
 *      类型 1：三元组 (i, j, k) ，如果 nums1[i]2 == nums2[j] * nums2[k] 其中 0 <= i < nums1.length 且 0 <= j < k < nums2.length
 *      类型 2：三元组 (i, j, k) ，如果 nums2[i]2 == nums1[j] * nums1[k] 其中 0 <= i < nums2.length 且 0 <= j < k < nums1.length
 * 难度：medium
 *
 **/
public class NumTriplets {

    public static void main(String[] args) {
        System.out.println();
        NumTriplets nt = new NumTriplets();
        System.out.println(nt.numTriplets1(new int[]{1,1},new int[]{1,1,1}));
    }


    public int numTriplets1(int[] nums1, int[] nums2) {

        Map<Long,Integer> map1 = new HashMap<>();
        Map<Long,Integer> map2 = new HashMap<>();

        for(int i = 0 ; i < nums1.length - 1 ; i ++) {
            for(int j = i + 1 ; j < nums1.length ; j ++ ) {
                long add = this.add(nums1[i],nums1[j]);
                map1.put(add,map1.getOrDefault(add,0) + 1);
            }
        }
        for(int i = 0 ; i < nums2.length - 1 ; i ++) {
            for(int j = i + 1 ; j < nums2.length ; j ++ ) {
                long add = this.add(nums2[i],nums2[j]);
                map2.put(add,map2.getOrDefault(add,0) + 1);
            }
        }
        int result = 0;
        for(int num : nums1) {
            long add = this.add(num,num);
            result += map2.getOrDefault(add,0);
        }
        for(int num : nums2) {
            result += map1.getOrDefault(this.add(num,num),0);
        }
        return result;
    }

    public long add(int num1, int num2) {
        return (long)num1 * (long)num2;
    }

    private int result = 0;
    public int numTriplets(int[] nums1, int[] nums2) {

        if(nums1 == null || nums2 == null) {
            return 0;
        }
        for(int i = 0 ; i < nums1.length ; i ++) {
            if(nums2.length < 2) {
                break;
            }
            digui((long)nums1[i] * (long)nums1[i] , nums2 , 0 , new ArrayList<>());
        }
        for(int i = 0 ; i < nums2.length ; i ++) {
            if(nums1.length <2) {
                break;
            }
            digui((long)nums2[i]*(long)nums2[i] , nums1 , 0 , new ArrayList<>());
        }
        return result;

    }

    private void digui(long target, int[] nums2, int start, ArrayList<Integer> list) {
        if(list.size() == 2) {
            if(target == (long)list.get(0) * (long)list.get(1)) {
                result ++;
            }
            return ;
        }
        for( ; start < nums2.length ; start ++) {
            list.add(nums2[start]);
            digui(target,nums2,start + 1 , list);
            list.remove(list.size() - 1);
        }
    }


}
