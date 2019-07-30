package com.zhao.leetcode.integer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  只出现一次的数字 II
 *  给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现了三次。找出那个只出现了一次的元素。
 */
public class ThreeNum {

    public static void main(String[] args) {
        int nums = 1;
        int num = 2;
        System.out.println(num & nums);
        System.out.println(~0);

        singleNumbers(new int[]{2,2,2,3});
    }

    public static int singleNumbers(int[] nums) {
        int a=0,b=0;
        for(int i=0;i<nums.length;i++){
            a=(a^nums[i]) & ~b;
            b=(b^nums[i]) & ~a;
        }
        return a;
    }

    public static int singleNumber(int[] nums) {

        Map<Integer,Integer> hashMap = new HashMap<>();
        for(int i = 0 ; i < nums.length ; i ++) {
            Integer inum = hashMap.get(nums[i]) ;
            if(inum == null) {
                hashMap.put(nums[i],1);
            } else {
                hashMap.put(nums[i], ++inum );
            }
        }
        for (HashMap.Entry<Integer,Integer> entry : hashMap.entrySet()) {
            if(entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return -1;
    }

}
